package com.zzzkvidi4.web_store.utils;

import com.zzzkvidi4.web_store.models.Order;
import com.zzzkvidi4.web_store.models.OrderItem;
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

    public static Order unproxy(Order order, boolean withItems){
        Order tmp = new Order();
        tmp.setDate(order.getDate());
        tmp.setOrderId(order.getOrderId());
        tmp.setStatus(order.getStatus());
        if (withItems) {
            order.getItems().forEach(item -> {
                OrderItem bufItem = new OrderItem();
                bufItem.setProduct(unproxy(item.getProduct()));
                bufItem.setOrderItemId(item.getOrderItemId());
                bufItem.setProductId(item.getProductId());
                bufItem.setCount(item.getCount());
                tmp.getItems().add(bufItem);
            });
        }
        tmp.setPrice(order.getPrice());
        return tmp;
    }
}
