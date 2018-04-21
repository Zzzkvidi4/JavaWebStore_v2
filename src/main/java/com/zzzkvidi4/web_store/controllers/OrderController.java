package com.zzzkvidi4.web_store.controllers;

import com.zzzkvidi4.web_store.models.Order;
import com.zzzkvidi4.web_store.responses.JsonHttpResponse;
import com.zzzkvidi4.web_store.services.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.zzzkvidi4.web_store.utils.HelpUtils.checkAuthentication;

@RestController
public class OrderController {
    @Resource(name = "orderService")
    private OrderService orderService;

    @RequestMapping(value = "/users/{userId}/orders/{orderId}", method = RequestMethod.GET)
    public JsonHttpResponse<Order> getUserOrder(@PathVariable("userId") int userId, @PathVariable("orderId") int orderId){
        JsonHttpResponse<Order> response = new JsonHttpResponse<>();
        if (checkAuthentication(response, userId)) {
            Order order = orderService.getOrderById(orderId, userId);
            response.setData(order);
            response.setSuccessful(order != null);
        }
        return response;
    }

    @RequestMapping(value = "/users/{userId}/orders/{orderId}", method = RequestMethod.PUT)
    public JsonHttpResponse<Void> closeUserOrder(@PathVariable("userId") int userId, @PathVariable("orderId") int orderId){
        JsonHttpResponse<Void> response = new JsonHttpResponse<>();
        if (checkAuthentication(response, userId)) {
            response.setSuccessful(orderService.setOrderClosed(orderId, userId));
        }
        return response;
    }
}
