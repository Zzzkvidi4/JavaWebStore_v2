package com.zzzkvidi4.web_store.utils;

import com.zzzkvidi4.web_store.models.User;
import com.zzzkvidi4.web_store.responses.JsonHttpResponse;
import com.zzzkvidi4.web_store.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.Resource;

public class HelpUtils {
    @Resource(name = "userService")
    private static UserService userService;

    public static <T> boolean checkAuthentication(JsonHttpResponse<T> response, int id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserById(id, false);
        if ((user == null) || (!userService.findUserById(id, false).getLogin().equals(auth.getName()))) {
            response.addError("You cant't effect on another user!");
            return false;
        }
        return true;
    }
}
