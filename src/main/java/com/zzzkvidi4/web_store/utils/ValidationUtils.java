package com.zzzkvidi4.web_store.utils;

import com.zzzkvidi4.web_store.models.User;

import java.util.List;

/**
 * Created by Роман on 30.04.2018.
 */
public class ValidationUtils {
    public enum Mode{
        CREATE, INSERT, UPDATE
    }

    public static boolean checkUser(User user, Mode mode, List<String> errors){
        boolean isCorrect = true;
        switch (mode) {
            case CREATE:{
                if (user.getName().length() < 5) {
                    isCorrect = false;
                    errors.add("Name shouldn't be less than 5 characters!");
                }

                if (user.getSurname().length() < 5) {
                    isCorrect = false;
                    errors.add("Surname shouldn't be less than 5 characters!");
                }

                if (user.getLogin().length() < 5) {
                    isCorrect = false;
                    errors.add("Login shouldn't be less than 5 characters!");
                }

                if (user.getPassword().length() < 5) {
                    isCorrect = false;
                    errors.add("Password shouldn't be less than 5 characters!");
                }
            }
        }
        return isCorrect;
    }
}
