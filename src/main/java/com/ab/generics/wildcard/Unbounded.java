package com.ab.generics.wildcard;

import com.ab.generics.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class Unbounded {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.add(new Person("Nish", 28));
        System.out.println(objects);

        //Compile time error
        /*List<?> objects2 = new ArrayList<>();
        objects2.add(new Object());
        objects2.add(new Person("Nish", 28));
        System.out.println(objects2);*/

        //As adding use contra variance
        List<? super Object> objects2 = new ArrayList<>();
        objects2.add(new Object());
        objects2.add(new Person("Nish", 28));
        System.out.println(objects2);

        //the only value pass through ? is null
        List<?> objects3 = new ArrayList<>();
        objects3.add(null);
        System.out.println(objects3);
    }
}
