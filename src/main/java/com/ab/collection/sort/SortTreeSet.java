package com.ab.collection.sort;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Arpit Bhardwaj
 *
 * TreeSet:orders(sort) the elements during add and uses compareTo method for the same
 */
public class SortTreeSet {
    private static class Drink implements Comparable{
        public String name;
        @Override
        public int compareTo(Object o) {
            return 0;
        }

        @Override
        public String toString() {
            return "Drink{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        Drink one = new Drink();
        Drink two = new Drink();
        one.name = "Coffee";
        two.name = "tea";
        TreeSet set = new TreeSet();

        //in case the element which is getting added doesn't implement comparable interface
        //add method throws ClassCastException
        System.out.println(set.add(one));
        System.out.println(set.add(two));//duplicate element
        set.forEach(System.out::println);
    }
}


