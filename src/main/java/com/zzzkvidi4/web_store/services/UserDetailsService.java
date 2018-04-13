package com.zzzkvidi4.web_store.services;

import com.zzzkvidi4.web_store.models.User;
import com.zzzkvidi4.web_store.models.UserRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Stream;

@Service("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Resource(name = "userService")
    private AbstractUserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findUserByLogin(s);
        if (user == null){
            return null;
        }
        org.springframework.security.core.userdetails.User.UserBuilder builder = org.springframework.security.core.userdetails.User.builder();
        builder.username(user.getLogin());
        builder.password(user.getPassword());
        String[] rolesArray = user.getUserRoles().stream().map(role -> role.getRole().getName()).toArray(String[]::new);
        builder.roles(rolesArray);
        return builder.build();
    }
}
