package com.example.redisimplementation.datacache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CacheStore<T> {
    private final Cache<String, T> cache;

    public CacheStore(int ttl, TimeUnit timeUnit) {
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(ttl, timeUnit)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build();
    }

    public T get(String key) {
        return cache.getIfPresent(key);
    }

    public void add(String key, T value) {
        if(key != null && value != null) {
            cache.put(key, value);
        }
    }

    public void delete() {
        cache.invalidateAll();
    }

    public List<String> getAll() {
        return new ArrayList<>(cache.asMap().keySet());
    }
}
