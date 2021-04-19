package com.ab.generics.methods;

import com.ab.generics.classes_and_interfaces.AgeComparator;
import com.ab.generics.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListMinimumGeneric {
    public static void main(String[] args) {
        Person donDrapper = new Person("Don Drapper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDrapper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);

        System.out.println(madMen);

        //final Person youngestPerson = min(madMen, new AgeComparator());

        /*final Person youngestPerson = min(madMen, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });*/ //compile error

        final Person youngestPerson = min(madMen, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println(youngestPerson);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(24);
        numbers.add(45);
        numbers.add(12);

        System.out.println(min(numbers,Integer::compare));

    }
    private static <T> T min(List<T> values, Comparator<T> comparator) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List is empty, cannot find minimum");
        }

        T lowestElement = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            final T element = values.get(i);
            if (comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }
        return lowestElement;
    }
}
