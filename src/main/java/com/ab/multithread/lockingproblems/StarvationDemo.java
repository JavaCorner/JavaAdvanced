package com.ab.multithread.lockingproblems;

/**
 * @author Arpit Bhardwaj
 *
 * Starvation:threads are also waiting for each other.
 * But here waiting time is not infinite after some interval of time, waiting thread always gets the resources whatever is required to execute thread run() method.
 */
public class StarvationDemo extends Thread{

    public void run()
    {
        System.out.println(Thread.currentThread().getPriority()+ " execution starts");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getPriority() + " execution completes");
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread execution starts");

        //low priority thread will starved for resources
        for (int i = 10; i >=1; i--) {
            StarvationDemo t = new StarvationDemo();
            t.setPriority(i);
            t.start();

        }
        System.out.println("Main thread execution completes");
    }
}
