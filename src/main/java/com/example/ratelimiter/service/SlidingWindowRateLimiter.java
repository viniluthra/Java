package com.example.ratelimiter.service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowRateLimiter {

    private final JedisPool jedisPool;
    private final String scriptSha;
    private final int windowSizeInSec;
    private final int maxRequests;

    public SlidingWindowRateLimiter(JedisPool pool, String luaScript, int windowSize, int maxRequests) {
        this.jedisPool = pool;
        this.windowSizeInSec = windowSize;
        this.maxRequests = maxRequests;

        try (Jedis jedis = pool.getResource()) {
            this.scriptSha = jedis.scriptLoad(luaScript);
        }
    }

    public boolean isAllowed(String userId) {
        long currentTime = System.currentTimeMillis() / 1000;
        List<String> keys = new ArrayList<>();

        for (long i = currentTime - windowSizeInSec + 1; i <= currentTime; i++) {
            keys.add("rate_limit:" + userId + ":" + i);
        }

        String currentKey = "rate_limit:" + userId + ":" + currentTime;

        List<String> args = List.of(
                currentKey,
                String.valueOf(maxRequests),
                String.valueOf(windowSizeInSec + 1)
        );

        try (Jedis jedis = jedisPool.getResource()) {
            Object result = jedis.evalsha(scriptSha, keys, args);
            return Long.valueOf(1).equals(result);
        }
    }
}

