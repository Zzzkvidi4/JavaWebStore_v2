package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.models.Order;

public interface OrderService {
    Order getOrderById(int orderId, int userId);
    boolean setOrderClosed(int orderId, int userId);
}
