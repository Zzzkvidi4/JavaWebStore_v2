package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.models.Product;
import com.zzzkvidi4.web_store.models.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> allProductTypes();
    List<Product> getProducts(int productTypeId);
}
