package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.models.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service("productService")
public class HibernateProductService implements ProductService {
    @Override
    public Product findProductById(int id) {
        return null;
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
