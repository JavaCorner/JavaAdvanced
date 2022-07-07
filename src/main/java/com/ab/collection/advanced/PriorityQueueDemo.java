package com.ab.collection.advanced;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author Arpit Bhardwaj
 *
 * PriorityQueue
 *      implements Queue interface and provides a sorted element from the head of the queue
 *      gurrantees the lowest or highest priority element will be on the head of the queue.
 *      remove and poll fetch the priority element on head and next on priority will acquire the head spot via internal max/min heapification
 *      default PriorityQueue is implemented with Min-Heap.
 *
 * Though it provides sorting, it's little different with other Sorted collections e.g. TreeSet or TreeMap,
 * which also allows you to iterate over all elements in sorted order,
 * instead in priority queue there is no guarantee of sorting on iteration.
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(16);//default uses min heap
        //PriorityQueue<Integer> pq = new PriorityQueue<>(16, Collections.reverseOrder());// for max heap
        pq.add(3);
        pq.add(7);
        pq.add(2);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        printPriorityQueue(pq);

        Integer head = pq.peek();

        System.out.println("Size of Priority Queue : " + pq.size());
        System.out.println("Head of Priority Queue : " + head);

        System.out.println("Polled Head of Priority Queue : " + pq.poll());

        head = pq.peek();

        System.out.println("Size of Priority Queue : " + pq.size());
        System.out.println("Head of Priority Queue : " + head);

        printPriorityQueue(pq);
    }

    private static void printPriorityQueue(PriorityQueue<Integer> pq) {
        Iterator<Integer> itr = pq.iterator();
        System.out.println("Printing Priority Queue..");
        while (itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
        System.out.println();
    }
}
