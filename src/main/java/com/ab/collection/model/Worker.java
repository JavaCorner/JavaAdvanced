package com.ab.collection.model;

import java.util.Comparator;

/**
 * @author Arpit Bhardwaj
 *
 * Java provides Comparable interface which should be implemented by any custom class
 * if we want to use Arrays or Collections sorting methods.
 */
public class Worker implements Comparable<Worker>{
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private long salary;

    public Worker(int id, String firstName, String lastName, int age, long salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    //by default sort the workers based on an id in ascending order
    @Override
    public int compareTo(Worker w1) {
        return this.id - w1.id;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

}
