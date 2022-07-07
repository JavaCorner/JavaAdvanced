package com.ab.multithread.basics;

import com.ab.multithread.model.Counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Arpit Bhardwaj
 *
 * Monitor exist for beow choice:
 *      Class
 *      Current Object
 *      Arbitrary Object
 *
 * The synchronized keyword can be used on different levels:
 *      Instance methods : are synchronized over the instance of the class owning the method.
 *                         Which means only one thread per instance of the class can execute this method.
 *
 *      Static methods : These methods are synchronized on the class object associated with the class and
 *                       since only one class object exists per JVM per class,
 *                       only one thread can execute inside a static synchronized method per class, irrespective of the number of instances it has.
 *
 */
public class SynchronizedDemo {
    static class Counter{
        int count = 0;
        /*public int incrementAndGet(){
            count = count + 1;
            return count;
        }*/
        //synchronized keyword on instance method,put the below method in blocked state against current instance of this class
        /*public synchronized int incrementAndGet(){
            count = count + 1;
            return count;
        }*/
        //synchronized keyword on static method, put the below method in blocked state against the class
        /*public static synchronized int incrementAndGet(){
            count = count + 1;
            return count;
        }*/

        /*public int incrementAndGet(){
            synchronized (this){
                count = count + 1;
            }
            return count;
        }*/

        public int incrementAndGet(){
            synchronized (Counter.class){
                count = count + 1;
            }
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Counter counter = new Counter();
        long startTime = System.currentTimeMillis();
        IntStream.range(1,1000)
                .forEach(count -> executorService.submit(counter::incrementAndGet));

        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);

        executorService.shutdown();
        while(!executorService.isTerminated()){}

        System.out.println(counter.incrementAndGet());

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
