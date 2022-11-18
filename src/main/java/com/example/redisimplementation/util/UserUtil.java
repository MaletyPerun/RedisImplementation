package com.example.redisimplementation.util;

import com.example.redisimplementation.model.User;
import com.example.redisimplementation.to.UserTo;

public class UserUtil {
    public static User createNewUserFromUserTo(UserTo userTo) {
        return new User(userTo.getLogin(), userTo.getPassword());
    }
}
