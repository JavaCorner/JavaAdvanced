package com.ab.multithread.basics;

//import com.sun.org.apache.xpath.internal.operations.Mult;

/**
 * @author Arpit Bhardwaj
 *
 * Threads can be created by using two mechanisms :
 *      Extending the Thread class
 *      Implementing the Runnable Interface (Recommended)
 *
 * If we extend the Thread class, our class cannot extend any other class because Java doesn’t support multiple inheritance
 * Using runnable will give you an object that can be shared amongst multiple threads.
 *
 * Thread Lifecycle
 *      NEW:            Thread has not yet started
 *      RUNNABLE:       Thread is executing
 *      BLOCKED:        Thread is blocked, waiting for monitor lock to be released
 *      WAITING:        Thread is waiting as long as it takes for another thread's signal
 *      TIMED_WAITING:  Thread is waiting for a specified period of time
 *      TERMINATED:     Thread is exited
 */
public class MultiThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is running");

        //************* Extending the Thread class *************//
        MultiThread1 t1 = new MultiThread1();
        t1.setName("Thread t1");
        t1.start();
        t1.join(); //put the current thread on wait until the thread on which it is called is dead.

        //************* Implementing the Runnable Interface *************//
        Runnable runnable2 = new MultiThread2();
        Thread t2 = new Thread(runnable2);
        t2.setName("Thread t2");
        t2.start();
        t2.join(10); //put the current thread on wait until the thread on which it is called is dead or wait for specified time

        //************* Implementing the Anonymous Runnable Interface *************//
        Runnable runnable1 = ()-> System.out.println(Thread.currentThread().getName() + " is running");
        Thread t3 = new Thread(runnable1);
        t3.setName("Thread t3");
        //The purpose of start() is to create a separate call stack for the thread.
        // A separate call stack is created by it, and then run() is called by JVM.
        t3.start();
        //t3.run(); //not run as a separate thread instead as part of main thread

        System.out.println(Thread.currentThread().getName() + " is finished");
    }

    static class MultiThread1 extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is finished");
        }
    }

    static class MultiThread2 implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is finished");
        }
    }
}
