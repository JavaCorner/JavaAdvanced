package com.ab.multithread.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Arpit Bhardwaj
 *
 * It extends RecursiveAction, which allows us to implement the compute method used in computing tasks using a thread pool
 * It recursively breaks down tasks into sub-tasks based on the granularity value
 * The constructors take lower and upper bound values which control the range of numbers we want to determine prime numbers for
 * It enables us to determine prime numbers using either a work-stealing thread pool or a single thread
 */

public class PrimeNumbers extends RecursiveAction {

    private int lowerBound;
    private int upperBound;
    private int granularity;
    static final List<Integer> GRANULARITIES
            = Arrays.asList(1, 10, 100, 1000, 10000);
    private AtomicInteger noOfPrimeNumbers;

    PrimeNumbers(int lowerBound, int upperBound, int granularity, AtomicInteger noOfPrimeNumbers) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.granularity = granularity;
        this.noOfPrimeNumbers = noOfPrimeNumbers;
    }

    // other constructors and methods

    private List<PrimeNumbers> subTasks() {
        List<PrimeNumbers> subTasks = new ArrayList<>();

        for (int i = 1; i <= this.upperBound / granularity; i++) {
            int upper = i * granularity;
            int lower = (upper - granularity) + 1;
            subTasks.add(new PrimeNumbers(lower, upper,granularity, noOfPrimeNumbers));
        }
        return subTasks;
    }

    @Override
    protected void compute() {
        if (((upperBound + 1) - lowerBound) > granularity) {
            ForkJoinTask.invokeAll(subTasks());
        } else {
            findPrimeNumbers();
        }
    }

    void findPrimeNumbers() {
        for (int num = lowerBound; num <= upperBound; num++) {
            if (isPrime(num)) {
                noOfPrimeNumbers.getAndIncrement();
            }
        }
    }

    private boolean isPrime(int num) {
        return false;
    }

    public int noOfPrimeNumbers() {
        return noOfPrimeNumbers.intValue();
    }
}
