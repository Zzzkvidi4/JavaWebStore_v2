package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.models.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<String> createOrderItem(OrderItem item, String username);

    List<String> deleteOrderItem(int orderItemId, String username);
}
