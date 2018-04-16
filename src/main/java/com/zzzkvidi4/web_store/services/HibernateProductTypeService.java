package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.DBHelper;
import com.zzzkvidi4.web_store.models.Product;
import com.zzzkvidi4.web_store.models.ProductType;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service("productTypeService")
public class HibernateProductTypeService implements ProductTypeService {

    @Override
    public List<ProductType> allProductTypes() {
        try (Session session = DBHelper.getSession()) {
            Transaction transaction = session.beginTransaction();
            List<ProductType> productTypes = session.createQuery("from ProductType", ProductType.class).list();
            transaction.commit();
            return productTypes;
        }
    }

    @Override
    public List<Product> getProducts(int productTypeId) {
        try (Session session = DBHelper.getSession()){
            Transaction transaction = session.beginTransaction();
            ProductType productType = session
                    .createQuery("from ProductType productType where productType.id = :productTypeId", ProductType.class)
                    .setParameter("productTypeId", productTypeId).getSingleResult();
            Hibernate.initialize(productType.getProducts());
            transaction.commit();
            List<Product> products = new LinkedList<>();
            products.addAll(productType.getProducts());
            return products;
        }
    }
}
