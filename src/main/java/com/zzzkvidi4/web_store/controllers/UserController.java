package com.zzzkvidi4.web_store.controllers;

import com.zzzkvidi4.web_store.models.User;
import com.zzzkvidi4.web_store.responses.JsonHttpResponse;
import com.zzzkvidi4.web_store.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.zzzkvidi4.web_store.utils.HelpUtils.checkAuthentication;

@RestController
public class UserController {

    @Resource(name = "userService")
    private UserService userService;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.allUsers();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonHttpResponse<Void> createUser(@RequestBody User user){
        JsonHttpResponse<Void> response = new JsonHttpResponse<>();
        response.addErrors(userService.createUser(user));
        return response;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public JsonHttpResponse<User> userInfo(@PathVariable("id") int id){
        JsonHttpResponse<User> response = new JsonHttpResponse<>();
        if (checkAuthentication(response, id)){
            User user = userService.findUserById(id, false);
            response.setData(user);
            response.setSuccessful(user != null);
        }
        return response;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public JsonHttpResponse<Void> updateUser(@PathVariable("id") int id, @RequestBody User user){
        JsonHttpResponse<Void> response = new JsonHttpResponse<>();
        if (checkAuthentication(response, id)) {
            user.setUserId(id);
            response.addErrors(userService.updateUser(user));
        }
        return response;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public JsonHttpResponse<Void> deleteUser(@PathVariable("id") int id){
        JsonHttpResponse<Void> response = new JsonHttpResponse<>();
        if (checkAuthentication(response, id)) {
            userService.deleteUser(id);
        }
        return response;
    }
}
