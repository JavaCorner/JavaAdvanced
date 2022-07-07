package com.ab.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Arpit Bhardwaj
 *
 * add and offer inserts the element if there is a space
 *      add throws IllegalStateException if queue is full
 *      offer does not throw exception when the queue is full, it returns false instead
 *
 * poll and remove returns and removes the element
 *      remove throws NoSuchElementException when the queue is empty
 *      poll does not throw exception when the queue is empty, it returns null instead
 *
 * element and peek returns the head element without
 *       element throws NoSuchElementException when the queue is empty
 *       peek does not throw exception when the queue is empty, it returns null instead
 *
 *          Throws exception     Returns special value
 * Insert   add(e)                  offer(e)
 * Remove   remove()                poll()
 * Examine  element()               peek()
 *
 */

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
    }
}
