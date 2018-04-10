package com.zzzkvidi4.web_store.controllers;

import com.zzzkvidi4.web_store.models.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private AtomicLong counter = new AtomicLong(0);
    private String template = "Hello, %s!";

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(required = false, defaultValue = "User") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
