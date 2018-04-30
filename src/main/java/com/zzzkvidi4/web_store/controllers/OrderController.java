package com.zzzkvidi4.web_store.controllers;

import com.zzzkvidi4.web_store.models.Order;
import com.zzzkvidi4.web_store.responses.JsonHttpResponse;
import com.zzzkvidi4.web_store.services.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

import static com.zzzkvidi4.web_store.utils.HelpUtils.checkAuthentication;

@RestController
public class OrderController {
    @Resource(name = "orderService")
    private OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public JsonHttpResponse<List<Order>> getAllOrders(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        JsonHttpResponse<List<Order>> response = new JsonHttpResponse<>();
        response.setData(orderService.getAllOrders(auth.getName()));
        return response;
    }

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    public JsonHttpResponse<Order> getUserOrder(@PathVariable("orderId") int orderId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        JsonHttpResponse<Order> response = new JsonHttpResponse<>();
        Order order = orderService.getOrderById(orderId, auth.getName());
        response.setData(order);
        response.setSuccessful(order != null);
        return response;
    }

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.PUT)
    public JsonHttpResponse<Void> closeUserOrder(@PathVariable("orderId") int orderId){
        JsonHttpResponse<Void> response = new JsonHttpResponse<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        response.setSuccessful(orderService.setOrderClosed(orderId, auth.getName()));
        return response;
    }
}
