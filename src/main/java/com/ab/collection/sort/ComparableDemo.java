package com.ab.collection.sort;

import com.ab.collection.model.Worker;
import com.ab.collection.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Arpit Bhardwaj
 *
 * We don’t need to make any code changes at client side for using Comparable Objects.
 * Arrays.sort() or Collection.sort() methods automatically uses the compareTo() method of the class.
 */
public class ComparableDemo {

    public static void main(String[] args) {
        //sorting object array
        Worker[] workerArr = new Worker[4];
        workerArr[0] = new Worker(10, "Mikey","Husy", 25, 10000);
        workerArr[1] = new Worker(20, "Arun","Kumar", 29, 20000);
        workerArr[2] = new Worker(5, "Lisa","Ray", 35, 5000);
        workerArr[3] = new Worker(1, "Pankaj","Udhas", 32, 50000);
        Utils.printArray(workerArr);

        //since the Worker implicitly implements Comparable, hence sort will make use of it
        //Arrays.sort throw ClassCastException in case the Worker didn't implement Comparable
        Arrays.sort(workerArr);

        Utils.printArray(workerArr);
    }
}
