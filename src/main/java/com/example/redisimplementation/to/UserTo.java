package com.example.redisimplementation.to;

import com.example.redisimplementation.model.User;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class UserTo extends User {

    @NotBlank
    String login;

    @NotBlank
    String password;

    public UserTo(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
