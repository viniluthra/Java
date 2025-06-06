package com.example.ratelimiter.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

@Service
public class ConcurrencyTestService {

    @Async
    public CompletableFuture<Integer> sendAsyncRequest(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            return CompletableFuture.completedFuture(responseCode);
        } catch (Exception e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture(500); // Indicate failure
        }
    }
}
