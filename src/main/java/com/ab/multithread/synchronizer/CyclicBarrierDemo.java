package com.ab.multithread.synchronizer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Arpit Bhardwaj
 *
 * CyclicBarrier
 *      can be used to implement multiple threads waiting for each other.
 *      can be used to in case of the recurrent event e.g. concurrently calculating a solution of the big problem
 * you can reuse CyclicBarrier by calling reset() method which resets Barrier to its initial State.
 */
public class CyclicBarrierDemo {

    static class BarrierTask implements Runnable{

        private CyclicBarrier barrier;

        public BarrierTask(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is waiting at barrier");
            try {
                barrier.await();
                System.out.println(threadName + " has crossed the barrier");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("All parties are arrived at the barrier. Let move ahead");
            }
        });

        Thread t1 = new Thread(new BarrierTask(barrier), "Task 1");
        Thread t2 = new Thread(new BarrierTask(barrier), "Task 2");
        Thread t3 = new Thread(new BarrierTask(barrier), "Task 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
