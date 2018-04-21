package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.DBHelper;
import com.zzzkvidi4.web_store.models.Order;
import com.zzzkvidi4.web_store.models.Status;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service("orderService")
public class HibernateOrderService implements OrderService {
    @Override
    public Order getOrderById(int orderId, int userId) {
        try (Session session = DBHelper.getSession()){
            Transaction transaction = session.beginTransaction();
            try {
                Order order = session
                        .createQuery("from Order where user.userId = :userId and orderId = :orderId", Order.class)
                        .setParameter("userId", userId)
                        .setParameter("orderId", orderId)
                        .getSingleResult();
                Hibernate.initialize(order);
                transaction.commit();
                return order;
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
}
