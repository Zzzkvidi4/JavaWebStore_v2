package com.zzzkvidi4.web_store.utils;

import com.zzzkvidi4.web_store.models.Product;
import com.zzzkvidi4.web_store.models.ProductType;

public class UnproxyUtils {
    public static ProductType unproxy(ProductType productType){
        ProductType tmp = new ProductType();
        tmp.setProductTypeId(productType.getProductTypeId());
        tmp.setName(productType.getName());
        return tmp;
    }

    public static Product unproxy(Product product){
        Product tmp = new Product();
        tmp.setProductId(product.getProductId());
        tmp.setCount(product.getCount());
        tmp.setName(product.getName());
        tmp.setPrice(product.getPrice());
        tmp.setProductTypeId(product.getProductTypeId());
        tmp.setCountryId(product.getCountryId());
        return tmp;
    }
}
