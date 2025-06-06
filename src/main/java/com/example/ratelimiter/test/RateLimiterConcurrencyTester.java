package com.example.ratelimiter.test;

import com.example.ratelimiter.service.ConcurrencyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class RateLimiterConcurrencyTester implements CommandLineRunner {

    @Autowired
    private ConcurrencyTestService testService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("⚡ Waiting for app to be ready...");

        try {
            Thread.sleep(3000); // Wait 3 seconds for app to fully start
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("🚀 Starting concurrency test...");

        String url = "http://localhost:8080/api/test?userId=user129"; // Make sure this hits your real rate-limited endpoint

        List<CompletableFuture<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futures.add(testService.sendAsyncRequest(url));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        long success = futures.stream().filter(f -> {
            try {
                return f.get() == 200;
            } catch (Exception e) {
                return false;
            }
        }).count();

        long rateLimited = futures.stream().filter(f -> {
            try {
                return f.get() == 429;
            } catch (Exception e) {
                return false;
            }
        }).count();

        System.out.println("Allowed Requests (HTTP 200): " + success);
        System.out.println("Blocked Requests (HTTP 429): " + rateLimited);
    }
}
