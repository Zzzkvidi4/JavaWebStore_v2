package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.DBHelper;
import com.zzzkvidi4.web_store.models.ProductType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

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
}
