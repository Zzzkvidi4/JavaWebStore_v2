package com.zzzkvidi4.web_store.controllers;

import com.zzzkvidi4.web_store.DBHelper;
import com.zzzkvidi4.web_store.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("from User", User.class).list();
        transaction.commit();
        session.close();
        return users;
    }
}
