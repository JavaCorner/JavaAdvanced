package com.ab.multithread.executorframework;

import com.ab.multithread.model.CallableTask;
import com.ab.multithread.model.RunnableTask;

import java.util.concurrent.*;

/**
 * @author Arpit Bhardwaj
 *
 * Executor - execute()
 *      ExecutorService`- submit()
 *      ScheduledExecutorService
 *          AbstractExecutorService
 *              ForkJoinPool
 *              ThreadPoolExecutor
 *              ScheduledThreadPoolExecutor
 *
 * The java.util.concurrent.ThreadPoolExecutor is an implementation of the java.util.concurrent.ExecutorService interface.
 *
 *      Fixed Thread Pool                   Executors.newFixedThreadPool(int)                   ThreadPoolExecutor
 *      Work Stealing Pool                  Executors.newWorkStealingPool()                     ForkJoinPool
 *      Single Thread Executor              Executors.newSingleThreadExecutor();                ThreadPoolExecutor
 *      Cached Thread Pool                  Executors.newCachedThreadPool();                    ThreadPoolExecutor
 *      Scheduled Thread Pool               Executors.newScheduledThreadPool(int);              ScheduledThreadPoolExecutor
 *      Single Thread Scheduled Executor    Executors.newSingleThreadScheduledExecutor()        DelegatedScheduledExecutorService
 *      Unconfigurable Executor             Executors.unconfigurableExecutorService()           DelegatedExecutorService
 *      Unconfigurable Scheduled Executor   Executors.unconfigurableScheduledExecutorService()  DelegatedScheduledExecutorService
 *
 * Executors is a utility class for factory and utility methods for ExecutorService similar to Arrays and Collections
 *
 * If no custom thread factory instance is passed Java creates the threads with its internal thread factory.
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        //newSingleThreadExecutor() is equivalent to newFixedThreadPool(1)
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(3,new CustomThreadFactory("CustomPool"));

        //Returns an object that delegates all defined ExecutorService methods to the given executor, but not any other methods that might otherwise be accessible using casts.
        ExecutorService executorService2 = Executors.unconfigurableExecutorService(executorService);

        //ExecutorService executorService = Executors.newCachedThreadPool();

        //ExecutorService executorService = Executors.newScheduledThreadPool(2);
        //ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        //schedules a runnable task to be executed every 5 sec with initial delay of 10 sec.
        //scheduledExecutorService.scheduleAtFixedRate(new Task(""), 10,5,TimeUnit.SECONDS);

        //ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        //Executor executor = Executors.newFixedThreadPool(5);

        //execute method is from Executor interface which accepts runnable but return void
        //Runnable objects are launched using execute and submit
        //Callable objects are launched using submit
        //Future<Integer>[] futures = new Future[10];
        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableTask(""+i));
            //executorService.submit(new RunnableTask(""+i));
            //futures[i] = executorService.submit(new CallableTask());
        }

        /*
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(futures[i].get(10, TimeUnit.SECONDS));
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }*/

        //The shutdown() method allows existing tasks to finish and prevents new tasks from being added.
        executorService.shutdown();

        //The shutdownNow() method
            //stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.
            //it doesn't wait for actively executing tasks to terminate and tries to stop them forcefully.
            //There are no guarantees beyond best-effort attempts to stop processing actively executing tasks.
            //This implementation cancels tasks via Thread.interrupt(), so any task that fails to respond to interrupts may never terminate.
        //executorService.shutdownNow();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //while (!executorService.isTerminated()){}
        System.out.println("Finished all threads execution");
    }
}
