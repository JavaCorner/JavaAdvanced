package com.ab.multithread.future;

import com.ab.multithread.model.CallableTask;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Arpit Bhardwaj
 *
 * one feature lacking in Runnable is that we cannot make a thread return result when it terminates, i.e. when run() completes.
 * For supporting this feature, the Callable interface is present in Java.
 *
 *
 */
public class CallableFutureDemo {
    public static void main(String[] args) {
        FutureTask[] randomTask = new FutureTask[5];
        for (int i = 0; i < 5; i++) {
            randomTask[i] = new FutureTask(new CallableTask());
            //as Thread accepts only runnable, hence wrap the callable in FutureTask
            Thread t = new Thread(randomTask[i]);
            t.start();
        }
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(randomTask[i].get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}


