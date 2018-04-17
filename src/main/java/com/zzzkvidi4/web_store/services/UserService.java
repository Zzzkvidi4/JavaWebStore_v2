package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.models.User;

import java.util.List;

public interface UserService {
    User findUserById(int id, boolean isFull);
    User findUserByLogin(String login, boolean isFull);
    List<User> allUsers();
    List<String> createUser(User user);
    List<String> updateUser(User user);
    void deleteUser(int id);
}
