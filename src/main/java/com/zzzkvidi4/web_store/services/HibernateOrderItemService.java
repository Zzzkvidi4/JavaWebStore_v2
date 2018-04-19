package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.DBHelper;
import com.zzzkvidi4.web_store.models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service("orderItemService")
public class HibernateOrderItemService implements OrderItemService {
    @Override
    public List<String> createOrderItem(OrderItem item, String username) {
        List<String> errors = new LinkedList<>();
        try (Session session = DBHelper.getSession()) {
            Transaction transaction = session.beginTransaction();
            Product product = session.createQuery("from Product where id = :id", Product.class)
                    .setParameter("id", item.getProductId()).getSingleResult();
            List<Order> openedOrders = session.createQuery("from Order where status.name like '%OPENED%'", Order.class).list();
            Order order;
            if (openedOrders.size() == 0) {
                Status status = session.createQuery("from Status where name like '%OPENED%'", Status.class).getSingleResult();
                User user = session.createQuery("from User where login = :username", User.class)
                        .setParameter("username", username).getSingleResult();
                order = new Order();
                order.setDate(Timestamp.valueOf(LocalDateTime.now()));
                order.setUserId(user.getUserId());
                order.setStatusId(status.getStatusId());
                order.setPrice(0);
                session.save(order);
            } else {
                order = openedOrders.get(0);
            }
            item.setOrderId(order.getOrderId());
            int productCount = product.getCount();
            int itemCount = item.getCount();
            if (productCount >= itemCount) {
                product.setCount(productCount - itemCount);
                int prevPrice = order.getPrice();
                order.setPrice(prevPrice + itemCount * product.getPrice());
                session.save(item);
                session.save(order);
                session.save(product);
                transaction.commit();
            } else {
                errors.add("Not enough product on storage " + product.getName());
                transaction.rollback();
            }
            return errors;
        }
    }
}
