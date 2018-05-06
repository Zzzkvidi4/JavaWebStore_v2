package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.DBHelper;
import com.zzzkvidi4.web_store.models.Product;
import com.zzzkvidi4.web_store.models.ProductType;
import com.zzzkvidi4.web_store.utils.UnproxyUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("productTypeService")
public class HibernateProductTypeService implements ProductTypeService {

    @Override
    public List<ProductType> allProductTypes() {
        try (Session session = DBHelper.getSession()) {
            Transaction transaction = session.beginTransaction();
            List<ProductType> productTypes = session.createQuery("from ProductType", ProductType.class).list();
            transaction.commit();
            return productTypes.stream().map(UnproxyUtils::unproxy).collect(Collectors.toList());
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
            return productType.getProducts().stream().map(UnproxyUtils::unproxy).collect(Collectors.toList());
        }
    }
}
