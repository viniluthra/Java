package com.example.ratelimiter.config;

import com.example.ratelimiter.service.SlidingWindowRateLimiter;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
public class RateLimiterConfig {

    @Value("classpath:sliding_window.lua")
    private Resource luaScriptResource;


    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setJmxEnabled(false);  // 🔴 THIS LINE DISABLES JMX REGISTRATION
        return new JedisPool(config, "localhost", 6379);
    }

    @Bean
    public SlidingWindowRateLimiter rateLimiter(JedisPool jedisPool) throws IOException {
        String luaScript = new String(luaScriptResource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        return new SlidingWindowRateLimiter(jedisPool, luaScript, 60, 2); // 5 reqs per 10 sec
    }
}

