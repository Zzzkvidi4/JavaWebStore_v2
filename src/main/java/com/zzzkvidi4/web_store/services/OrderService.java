package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders(String login);
    Order getOrderById(int orderId, int userId);
    Order getOrderById(int orderId, String login);
    boolean setOrderClosed(int orderId, int userId);
    boolean setOrderClosed(int orderId, String login);
}
