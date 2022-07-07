package com.ab.multithread.future;

import com.ab.multithread.model.CallableTask;
import com.ab.multithread.model.RunnableTask;

import java.util.concurrent.*;

public class CallbackMechanism {
    public static class RunnableTask implements Runnable{
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("Starting Task : " + threadName);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ending Task : " + threadName);
        }
    }

    static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        CompletableFuture future = CompletableFuture.runAsync(new RunnableTask(),executor);
        try {
            future.get(100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            System.out.println("Cancelling the running callback");
            future.cancel(true); //this method will stop the running underlying task
        }
        executor.shutdown();
    }
}
