package com.ab.multithread.basics;

/**
 * @author Arpit Bhardwaj
 *
 * As soon as last nondaemon thread (user thread) finished JVM terminates no matter how many daemon thread exists or running inside JVM
 * It is an utmost low priority thread.
 *
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                try {
                    while (true){
                        System.out.println("Running " + name);
                    }
                }
                finally {
                    System.out.println("Ending " + name);
                }

            }
        });
        //throw IllegalThreadStateException if corresponding Thread is already started and running.

        t.setName("Demon Thread 1");
        t.setDaemon(true);
        t.start();
        //t.join();//this will lead the main to wait for daemon to finish
        Thread.sleep(10);
    }
}
