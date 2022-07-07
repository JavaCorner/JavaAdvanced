package com.ab.multithread.synchronizer;

import java.util.concurrent.CountDownLatch;

/**
 * @author Arpit Bhardwaj
 *
 * CountDownLatch
 *      can be used to implement multiple threads waiting for each other.
 *      is a good for one-time events like application start-up time
 *
 * You can not reuse CountDownLatch once the count reaches zero
 */
public class CountDownLatchDemo {
    static class Service implements Runnable {
        private final String name;
        private final int timeToStart;
        private final CountDownLatch latch;

        public Service(String name, int timeToStart, CountDownLatch latch) {
            this.name = name;
            this.timeToStart = timeToStart;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeToStart);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + " Service is Up!");
            latch.countDown();
        }
    }
    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(3);

        Thread cacheServiceThread = new Thread(new Service("Cache",1000,latch));
        Thread alertServiceThread = new Thread(new Service("Alert",1000,latch));
        Thread secureServiceThread = new Thread(new Service("Secure",1000,latch));

        cacheServiceThread.start();
        alertServiceThread.start();
        secureServiceThread.start();

        try {
            latch.await();
            System.out.println("All Services are up! Main Application is starting now");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
