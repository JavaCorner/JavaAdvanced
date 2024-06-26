package com.ab;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Throttling {
    public static void main(String[] args) {
        // Create a RateLimiter that allows 1 permit per second
        RateLimiter rateLimiter = RateLimiter.create(1.0);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new RunnableTask(rateLimiter));
        executorService.execute(new RunnableTask(rateLimiter));

        executorService.shutdown();
        try {
            executorService.awaitTermination(12, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished all threads execution");
    }

    private static class RunnableTask implements Runnable{

        private RateLimiter rateLimiter;

        public RunnableTask(RateLimiter rl) {
            this.rateLimiter = rl;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                double waitTime = rateLimiter.acquire(); // Request for a permit
                System.out.println("Acquired permit in " + waitTime + " seconds by " + Thread.currentThread().getName());
                // Perform the action you want to rate limit
            }
        }

    }

}


