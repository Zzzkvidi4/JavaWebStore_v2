package com.zzzkvidi4.web_store.controllers;

import com.zzzkvidi4.web_store.models.User;
import com.zzzkvidi4.web_store.services.AbstractUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource(name = "userService")
    private AbstractUserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.allUsers();
    }
}
