package com.example.redisimplementation.datacache;

import com.example.redisimplementation.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheStoreBeans {

    @Bean
    public CacheStore<User> userCache() {
        return new CacheStore<User>(15, TimeUnit.SECONDS);
    }

}
