package com.ab.generics.classes_and_interfaces;

import com.ab.generics.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        Person donDrapper = new Person("Don Drapper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDrapper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);

        System.out.println(madMen);

        Collections.sort(madMen, new AgeComparator());

        System.out.println(madMen);

        Collections.sort(madMen, new ReverseComparator<>(new AgeComparator()));

        System.out.println(madMen);
    }
}
