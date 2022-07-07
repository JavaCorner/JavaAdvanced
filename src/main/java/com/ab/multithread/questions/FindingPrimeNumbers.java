package com.ab.multithread.questions;

import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Arpit Bhardwaj
 */

public class FindingPrimeNumbers {
    public static void main(String[] args) {
        PrimeNumbers primes = new PrimeNumbers(10,1000,1000,new AtomicInteger(500));

        primes.findPrimeNumbers();

        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(primes);
        pool.shutdown();

        int parallelism = ForkJoinPool.getCommonPoolParallelism();
        ForkJoinPool stealer = (ForkJoinPool) Executors.newWorkStealingPool(parallelism);
        stealer.invoke(primes);
        stealer.shutdown();

    }
}
