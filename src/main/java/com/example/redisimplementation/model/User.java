package com.example.redisimplementation.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {

    private static int ID_USER = 0;

    private int id;
    private String login;
    private String password;

    public User(String login, String password) {
        this.id = ++ID_USER;
        this.login = login;
        this.password = password;
    }
}
