package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.models.Product;
import org.hibernate.Session;

public interface ProductService {
    Product findProductById(int id);

    Product findProductById(Session session, int id);
}
