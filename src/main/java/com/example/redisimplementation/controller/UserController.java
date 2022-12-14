package com.example.redisimplementation.controller;

import com.example.redisimplementation.datacache.CacheStore;
import com.example.redisimplementation.model.User;
import com.example.redisimplementation.to.UserTo;
import com.example.redisimplementation.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    public CacheStore<User> userCache;

    @GetMapping("/GET/{id}")
    public User getUserByID(@PathVariable String id) {

        if (id != null)
            return userCache.get(id);
        else
            return null;
    }

    @PostMapping(value = "/SET", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String setUser(@Valid @RequestBody UserTo userTo) {
        User created = UserUtil.createNewUserFromUserTo(userTo);
        userCache.add(String.valueOf(created.getId()), created);
        return "User add in cache with key = " + created.getId();
    }

    @DeleteMapping("/DEL")
    public String deleteUser() {
        userCache.delete();
        return "Cache is clear";
    }

    @GetMapping("/KEYS")
    public List<String> keys() {
        return userCache.getAll();
    }
}
