package com.ab.multithread.basics;

/**
 * @author Arpit Bhardwaj
 * The instance interrupt() method sets the interrupted flag
 * The instance isInterrupted() method returns the interrupted flag either true or false.
 * The static interrupted() method returns the interrupted flag afterthat it sets the flag to false if it is true.
 *
 * When thread is in running state, the interrupt signal has no effect untill its coded to check isInterrupted
 * When the thread is in waiting and timed waiting state, the interrupt signal produce InterruptedException else not
 */
public class InterruptStop {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //while (!t.isInterrupted()){
                while (!Thread.interrupted()){
                    System.out.println("Running Thread...");
                }

                System.out.println("Stopping Thread...");
            }
        });

        t.start();
        Thread.sleep(1);
        t.interrupt();
        Thread.sleep(1);
        System.out.println(t.isInterrupted());
    }
}
