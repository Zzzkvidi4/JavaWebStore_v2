package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.models.User;

import java.util.List;

public interface AbstractUserService {
    User findUserById(long id);
    User findUserByLogin(String login);
    List<User> allUsers();
}
