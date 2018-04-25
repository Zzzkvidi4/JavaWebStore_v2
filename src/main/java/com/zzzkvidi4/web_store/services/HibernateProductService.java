package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.DBHelper;
import com.zzzkvidi4.web_store.models.Product;
import com.zzzkvidi4.web_store.utils.UnproxyUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service("productService")
public class HibernateProductService implements ProductService {
    @Override
    public Product findProductById(int id) {
        try (Session session = DBHelper.getSession()){
            Transaction transaction = session.beginTransaction();
            try {
                Product product = session
                        .createQuery("from Product where productId = :id", Product.class)
                        .setParameter("id", id)
                        .getSingleResult();
                transaction.commit();
                return UnproxyUtils.unproxy(product);
            } catch (NoResultException e) {
                transaction.rollback();
                return null;
            }
        }
    }

    @Override
    public Product findProductById(Session session, int id) {
        try {
            return session
                    .createQuery("from Product where productId = :id", Product.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
