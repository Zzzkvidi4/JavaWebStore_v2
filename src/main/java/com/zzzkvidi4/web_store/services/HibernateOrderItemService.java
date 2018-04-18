package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.DBHelper;
import com.zzzkvidi4.web_store.models.OrderItem;
import com.zzzkvidi4.web_store.models.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class HibernateOrderItemService implements OrderItemService {
    @Override
    public List<String> createOrderItem(OrderItem item) {
        List<String> errors = new LinkedList<>();
        try (Session session = DBHelper.getSession()) {
            Transaction transaction = session.beginTransaction();
            Product product = session.createQuery("from Product where id = :id", Product.class)
                    .setParameter("id", item.getProductId()).getSingleResult();
            int productCount = product.getCount();
            int itemCount = item.getCount();
            if (productCount >= itemCount) {
                product.setCount(productCount - itemCount);
            } else {
                errors.add("Not enough product on storage " + product.getName());
            }
            transaction.commit();
            return errors;
        }
    }
}
