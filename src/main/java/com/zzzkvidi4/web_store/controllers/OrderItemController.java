package com.zzzkvidi4.web_store.controllers;

import com.zzzkvidi4.web_store.models.OrderItem;
import com.zzzkvidi4.web_store.responses.JsonHttpResponse;
import com.zzzkvidi4.web_store.services.OrderItemService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderItemController {
    @Resource(name = "orderItemService")
    private OrderItemService orderItemService;

    @RequestMapping(value = "/order_item", method = RequestMethod.POST)
    public JsonHttpResponse<Void> createOrderItem(@RequestBody OrderItem item){
        JsonHttpResponse<Void> response = new JsonHttpResponse<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        response.addErrors(orderItemService.createOrderItem(item, auth.getName()));
        return response;
    }
}
