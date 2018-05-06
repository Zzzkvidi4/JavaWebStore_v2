package com.zzzkvidi4.web_store.controllers;

import com.zzzkvidi4.web_store.models.OrderItem;
import com.zzzkvidi4.web_store.responses.JsonHttpResponse;
import com.zzzkvidi4.web_store.services.OrderItemService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class OrderItemController {
    @Resource(name = "orderItemService")
    private OrderItemService orderItemService;

    @RequestMapping(value = "/order_items", method = RequestMethod.POST)
    public JsonHttpResponse<Void> createOrderItem(@RequestBody OrderItem item){
        JsonHttpResponse<Void> response = new JsonHttpResponse<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (item.getCount() <= 0) {
            response.addError("You can't order zero or negative number of items!");
        } else {
            response.addErrors(orderItemService.createOrderItem(item, auth.getName()));
        }
        return response;
    }

    @RequestMapping(value = "/order_items/{id}", method = RequestMethod.DELETE)
    public JsonHttpResponse<Void> deleteOrderItem(@PathVariable("id") int id){
        JsonHttpResponse<Void> response = new JsonHttpResponse<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        response.addErrors(orderItemService.deleteOrderItem(id, auth.getName()));
        return response;
    }
}
