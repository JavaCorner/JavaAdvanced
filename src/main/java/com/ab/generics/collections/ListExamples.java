package com.ab.generics.collections;

import com.ab.generics.model.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExamples {
    public static void main(String[] args) {
        Person donDrapper = new Person("Don Drapper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDrapper);
        madMen.add(peggyOlson);

        System.out.println(madMen);

        madMen.add(new Person("Bert Cooper", 100));
        //madMen.add(new Object());//compile error
        System.out.println(madMen);

        for (int i = 0; i < madMen.size(); i++) {
            final Person person = madMen.get(i);
            System.out.println(person);
        }

        final Iterator<Person> iterator = madMen.iterator();
        while (iterator.hasNext()){
            final Person person = iterator.next();
            System.out.println(person);
        }

        for (Person person:madMen) {
            System.out.println(person);
        }
    }
}
