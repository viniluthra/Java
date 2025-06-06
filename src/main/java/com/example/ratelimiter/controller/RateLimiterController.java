package com.example.ratelimiter.controller;

import com.example.ratelimiter.service.SlidingWindowRateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RateLimiterController {

    private final SlidingWindowRateLimiter rateLimiter;

    public RateLimiterController(SlidingWindowRateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestParam(defaultValue = "user123") String userId) {
        boolean allowed = rateLimiter.isAllowed(userId);
        if (allowed) {
            return ResponseEntity.ok("Allowed");
        } else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Rate limit exceeded");
        }
    }
}
