package com.zzzkvidi4.web_store.controllers;

import com.zzzkvidi4.web_store.models.OrderItem;
import com.zzzkvidi4.web_store.responses.JsonHttpResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderItemController {

    @RequestMapping(value = "/order_item", method = RequestMethod.POST)
    public JsonHttpResponse<Void> createOrderItem(@RequestBody OrderItem item){
        JsonHttpResponse<Void> response = new JsonHttpResponse<>();

        return response;
    }
}
