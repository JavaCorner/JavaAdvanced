package com.ab.collection.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Arpit Bhardwaj
 *
 * thread-safe version of ArrayList.
 *
 * CopyOnWriteArrayList creates a cloned shallow copy of underlying ArrayList, for every update operation
 * at certain point both will be synced automatically ,which is taken care by JVM.
 * therefore, there is no effect for threads which are performing read operation.
 *
 * Iterator of CopyOnWriteArrayList class can perform only read operation
 * removal operation on iterator, throws java.lang.UnsupportedOperationException
 */
public class CopyOnWriteArrayListDemo implements Runnable{

    static CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<>();

    List<String> list = new ArrayList<>();
    List<String> copyOnList = new CopyOnWriteArrayList<>(list);

    public static void main(String[] args) throws InterruptedException {
        threadSafeList.add("A");
        threadSafeList.add("B");
        threadSafeList.add("C");

        Thread t = new Thread(new CopyOnWriteArrayListDemo());
        t.start();

        System.out.println(threadSafeList.toString());

        Iterator<String> iterator = threadSafeList.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            if (next.equals("B")){
                iterator.remove();//java.lang.UnsupportedOperationException
            }
        }

    }
    @Override
    public void run() {
        threadSafeList.add("D");
    }

}
