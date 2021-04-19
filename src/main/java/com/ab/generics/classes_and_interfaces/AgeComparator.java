package com.ab.generics.classes_and_interfaces;

import com.ab.generics.model.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        //ascending order
        //return Integer.compare(o1.getAge(),o2.getAge());
        //or
        return o1.getAge() - o2.getAge();
        //descending order
        //return -1 * Integer.compare(o1.getAge(),o2.getAge());
        //or
        //return o2.getAge() - o1.getAge();
    }
}
