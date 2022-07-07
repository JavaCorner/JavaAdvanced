package com.ab.multithread.model;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random generator = new Random();
        Integer randomInt = generator.nextInt(5);
        Thread.sleep(randomInt *1000);
        return randomInt;
    }
}
