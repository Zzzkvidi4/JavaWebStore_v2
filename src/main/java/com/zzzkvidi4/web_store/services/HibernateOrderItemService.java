package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.DBHelper;
import com.zzzkvidi4.web_store.models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.NoResultException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service("orderItemService")
public class HibernateOrderItemService implements OrderItemService {
    @Resource(name = "productService")
    private ProductService productService;

    @Override
    public List<String> createOrderItem(OrderItem item, String username) {
        List<String> errors = new LinkedList<>();
        try (Session session = DBHelper.getSession()) {
            Transaction transaction = session.beginTransaction();
            Product product = productService.findProductById(session, item.getProductId());
            if (product == null) {
                errors.add("No product with such id!");
                return errors;
            }
            Order order = findOpenedOrder(session, username);
            item.setOrderId(order.getOrderId());

            if (product.getCount() >= item.getCount()) {
                setUpOrderItem(session, product, order, item);
                transaction.commit();
            } else {
                errors.add("Not enough product on storage " + product.getName());
                transaction.rollback();
            }

            return errors;
        }
    }

    @Override
    public List<String> deleteOrderItem(int orderItemId, String username) {
        List<String> errors = new LinkedList<>();
        try (Session session = DBHelper.getSession()){
            Transaction transaction = session.beginTransaction();
            try{
                OrderItem item = session
                        .createQuery("from OrderItem where orderItemId = :id and order.status.name like '%OPENED%' and order.user.login = :username", OrderItem.class)
                        .setParameter("id", orderItemId)
                        .setParameter("username", username)
                        .getSingleResult();
                Order order = item.getOrder();
                Product product = item.getProduct();
                order.setPrice(order.getPrice() - item.getCount() * product.getPrice());
                product.setCount(product.getCount() + item.getCount());
                session.save(order);
                session.save(product);
                session.delete(item);
                transaction.commit();
            }
            catch (NoResultException e) {
                transaction.rollback();
                errors.add("Not found order item with such id in current user!");
            }
        }
        return errors;
    }

    private Order createOrder(Session session, String username){
        Status status = session.createQuery("from Status where name like '%OPENED%'", Status.class).getSingleResult();
        User user = session
                .createQuery("from User where login = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
        Order order = new Order();
        order.setDate(Timestamp.valueOf(LocalDateTime.now()));
        order.setUserId(user.getUserId());
        order.setStatusId(status.getStatusId());
        order.setPrice(0);
        session.save(order);
        return order;
    }

    private Order findOpenedOrder(Session session, String username){
        List<Order> openedOrders = session.createQuery("from Order where status.name like '%OPENED%'", Order.class).list();
        if (openedOrders.size() == 0) {
            return createOrder(session, username);
        } else {
            return openedOrders.get(0);
        }
    }

    private void setUpOrderItem(Session session, Product product, Order order, OrderItem item){
        product.setCount(product.getCount() - item.getCount());
        int prevPrice = order.getPrice();
        order.setPrice(prevPrice + item.getCount() * product.getPrice());
        session.save(item);
        session.save(order);
        session.save(product);
    }
}
