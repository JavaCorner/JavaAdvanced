package com.ab.generics.methods;

import com.ab.generics.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

//import static java.util.Collections.min;

public class ListMinimum {
    public static void main(String[] args) {
        Person donDrapper = new Person("Don Drapper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDrapper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);

        System.out.println(madMen);

        final Person youngestPerson = (Person) min(madMen, new AgeComparator());

        /*final Person youngestPerson = (Person) min(madMen, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });*/ //leads to class cast exception

        System.out.println(youngestPerson);
    }

    private static Object min(List values, Comparator comparator) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List is empty, cannot find minimum");
        }

        Object lowestElement = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            final Object element = values.get(i);
            if (comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }
        return lowestElement;
    }

    public static void test(Collection<?> collection){}
}
