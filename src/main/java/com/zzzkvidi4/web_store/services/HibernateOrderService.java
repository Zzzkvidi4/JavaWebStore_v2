package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.DBHelper;
import com.zzzkvidi4.web_store.models.Order;
import com.zzzkvidi4.web_store.models.Status;
import com.zzzkvidi4.web_store.utils.UnproxyUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service("orderService")
public class HibernateOrderService implements OrderService {
    @Override
    public List<Order> getAllOrders(String login) {
        List<Order> orders = null;
        try (Session session = DBHelper.getSession()) {
            Transaction transaction = session.beginTransaction();
            orders = session
                    .createQuery("from Order where user.login = :login", Order.class)
                    .setParameter("login", login)
                    .stream()
                    .map(order -> UnproxyUtils.unproxy(order, false))
                    .collect(Collectors.toList());
            transaction.commit();
        }
        return orders;
    }

    @Override
    public Order getOrderById(int orderId, int userId) {
        try (Session session = DBHelper.getSession()){
            Transaction transaction = session.beginTransaction();
            try {
                Order order = session
                        .createQuery("from Order o join fetch o.status join fetch o.items where o.user.userId = :userId and o.orderId = :orderId", Order.class)
                        .setParameter("userId", userId)
                        .setParameter("orderId", orderId)
                        .getSingleResult();
                Hibernate.initialize(order);
                transaction.commit();
                return UnproxyUtils.unproxy(order, true);
            } catch(NoResultException e) {
                transaction.rollback();
                return null;
            }
        }
    }

    @Override
    public Order getOrderById(int orderId, String login) {
        try (Session session = DBHelper.getSession()){
            Transaction transaction = session.beginTransaction();
            try {
                Order order = session
                        .createQuery("from Order o left outer join fetch o.status left outer join fetch o.items i left outer join fetch i.product where o.user.login = :login and o.orderId = :orderId", Order.class)
                        .setParameter("login", login)
                        .setParameter("orderId", orderId)
                        .getSingleResult();
                transaction.commit();
                return UnproxyUtils.unproxy(order, true);
            } catch(NoResultException e) {
                transaction.rollback();
                return null;
            }
        }
    }

    @Override
    public boolean setOrderClosed(int orderId, int userId) {
        try (Session session = DBHelper.getSession()){
            Transaction transaction = session.beginTransaction();
            try {
                Order order = session
                        .createQuery("from Order where user.userId = :userId and orderId = :orderId", Order.class)
                        .setParameter("userId", userId)
                        .setParameter("orderId", orderId)
                        .getSingleResult();
                Status status = session
                        .createQuery("from Status where name like '%CLOSED%'", Status.class)
                        .getSingleResult();
                order.setStatusId(status.getStatusId());
                session.save(order);
                transaction.commit();
                return true;
            } catch(NoResultException e) {
                transaction.rollback();
                return false;
            }
        }
    }

    @Override
    public boolean setOrderClosed(int orderId, String login) {
        try (Session session = DBHelper.getSession()){
            Transaction transaction = session.beginTransaction();
            try {
                Order order = session
                        .createQuery("from Order where user.login = :login and orderId = :orderId", Order.class)
                        .setParameter("login", login)
                        .setParameter("orderId", orderId)
                        .getSingleResult();
                Status status = session
                        .createQuery("from Status where name like '%CLOSED%'", Status.class)
                        .getSingleResult();
                order.setStatusId(status.getStatusId());
                session.save(order);
                transaction.commit();
                return true;
            } catch(NoResultException e) {
                transaction.rollback();
                return false;
            }
        }
    }
}
