package com.ab.collection.set;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * Hashset is indexed by hashcode and uses element hashCode method for the same
 * No arg constructor creates a set of initial capacity of 16 elements with Default Load Factor = 0.75 (75%)
 * Hash Set in order to check uniqueness is divided in buckets (segments) of similar hashcode elements.
 * so that it doesn't have to check all elements for uniqueness
 *
 * TreeSet:sort the elements during add and uses compareTo method for the same
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> primeNumbers1 = new HashSet<>();
        Set<Integer> primeNumbers3 = new HashSet<>(20,0.85F);
        Set<Integer> primeNumbers2 = new TreeSet<>();

        primeNumbers1.add(71);
        primeNumbers1.add(61);
        primeNumbers1.add(41);
        primeNumbers1.add(1);
        System.out.println(primeNumbers1);
        //hashset cannot be sort and the collections sort only accepts list type
        //Collections.sort(primeNumbers1);  //compile error

        primeNumbers2.add(71);
        primeNumbers2.add(61);
        primeNumbers2.add(41);
        primeNumbers2.add(1);
        System.out.println(primeNumbers2);

        Set<Integer> numbers = Set.of(1,2);//creates an immutable set
    }
}
