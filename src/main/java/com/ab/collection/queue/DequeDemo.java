package com.ab.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Arpit Bhardwaj
 *
 * No arg constructor creates a set of initial capacity of 16 elements
 * if deque is empty poll peek return null
 */
public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> integers = new ArrayDeque<>(20);
        integers.offerFirst(1);
        integers.offerFirst(4);
        integers.offerLast(5);
        integers.offerLast(10);
        integers.peekFirst();
        integers.pollFirst();
        integers.peekLast();
        integers.pollLast();
    }
}
