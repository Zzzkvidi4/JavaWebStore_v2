package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.DBHelper;
import com.zzzkvidi4.web_store.models.Role;
import com.zzzkvidi4.web_store.models.User;
import com.zzzkvidi4.web_store.models.UserRole;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class HibernateUserService implements UserService {
    @Override
    public User findUserById(int id, boolean isFull) {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        if (isFull) {
            Hibernate.initialize(user.getUserRoles());
            user.getUserRoles().forEach(userRole -> Hibernate.initialize(userRole.getRole()));
        }
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public User findUserByLogin(String login, boolean isFull) {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("from User u where u.login = :login", User.class)
                .setParameter("login", login).list();
        if (isFull) {
            users.forEach(user -> Hibernate.initialize(user.getUserRoles()));
            users.forEach(user -> user.getUserRoles().forEach(role -> Hibernate.initialize(role.getRole())));
        }
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

    @Override
    public void createUser(User user) {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        Role role = session.createQuery("from Role role where role.name like '%USER%'", Role.class).getSingleResult();
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getUserId());
        userRole.setRoleId(role.getRoleId());
        session.save(userRole);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(int id) {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
