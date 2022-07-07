package com.ab.collection.sort;

import com.ab.collection.model.Worker;
import com.ab.collection.util.Utils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Arpit Bhardwaj
 *
 * Comparator, we can define multiple methods with different ways of sorting
 * and then chose the sorting method based on our requirements.
 *
 * Comparator, client needs to provide the Comparator class to use in compare() method.
 */
public class ComparatorDemo {

    public static void main(String[] args) {
        Worker[] workerArr = new Worker[5];
        workerArr[0] = new Worker(10, "Mikey","Husy", 25, 23000);
        workerArr[1] = new Worker(20, "Arpit","Kumar", 29, 20000);
        workerArr[2] = new Worker(5, "Lisa","Ray", 35, 52000);
        workerArr[3] = new Worker(1, "Pankaj","Udhas", 32, 50000);
        workerArr[4] = new Worker(1, "Arpit","Bhardwaj", 30, 70000);
        Utils.printArray(workerArr);

        //can pass on the fly anonymous comparator
        Arrays.sort(workerArr, new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        });

        Utils.printArray(workerArr);

        //Sort on multiple fields – Group by sort
        //Method 1
        //compare two worker object first on their id and if they are same then on the name.
        Arrays.sort(workerArr, new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                int flag = o1.getId() - o2.getId();
                if(flag==0) flag = o1.getFirstName().compareTo(o2.getFirstName());
                return flag;
            }
        });

        Utils.printArray(workerArr);

        //Method 2
        //Compare by first name and then last name

        //comparing is static method of Comparator Interface
        //thenComparing and reversed are default methods
        Comparator<Worker> comparatorByFirstNameThenLastName = Comparator.comparing(Worker::getFirstName)
                .thenComparing(Worker::getLastName).reversed();

        Arrays.sort(workerArr,comparatorByFirstNameThenLastName);

        Utils.printArray(workerArr);
    }
}
