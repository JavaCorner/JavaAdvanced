package com.ab.generics.classes_and_interfaces;

import com.ab.generics.model.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
        //return -1 * Integer.compare(o1.getAge(),o2.getAge()); for sorting in descending order
    }
}
