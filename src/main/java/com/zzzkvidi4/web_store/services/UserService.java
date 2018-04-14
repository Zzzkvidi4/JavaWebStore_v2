package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.DBHelper;
import com.zzzkvidi4.web_store.models.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService implements AbstractUserService {
    @Override
    public User findUserById(long id) {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("from User u where u.id = :id", User.class).setParameter("id", id).list();
        transaction.commit();
        session.close();
        if (users.size() != 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public User findUserByLogin(String login) {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("from User u where u.login = :login", User.class)
                .setParameter("login", login).list();
        users.forEach(user -> Hibernate.initialize(user.getUserRoles()));
        users.forEach(user -> user.getUserRoles().forEach(role -> Hibernate.initialize(role.getRole())));
        transaction.commit();
        session.close();
        if (users.size() != 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<User> allUsers() {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("from User", User.class).list();
        users.forEach(user -> Hibernate.initialize(user.getUserRoles()));
        users.forEach(user -> user.getUserRoles().forEach(role -> Hibernate.initialize(role.getRole())));
        transaction.commit();
        session.close();
        return users;
    }
}
