package com.ab.generics.collections;

import com.ab.generics.model.Person;

import java.util.HashSet;
import java.util.Set;

public class SetExamples {
    public static void main(String[] args) {
        Person donDrapper = new Person("Don Drapper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        Set<Person> madMen = new HashSet<>();
        madMen.add(donDrapper);
        madMen.add(peggyOlson);
        madMen.add(donDrapper);

        System.out.println(madMen);

        System.out.println(madMen.contains(donDrapper));
        System.out.println(madMen.contains(bertCooper));
        //madMen.get(0);
        for (Person person:madMen) {
            System.out.println(person);
        }
    }
}
