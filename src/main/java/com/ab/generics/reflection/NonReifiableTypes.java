package com.ab.generics.reflection;

import java.util.ArrayList;
import java.util.List;

/**
 * Type T
 * Parametrized type with parameters
 * Parametrized type with bounds
 *
 * @author Arpit Bhardwaj
 */
public class NonReifiableTypes<T> {
    public static void main(String[] args) {
        //System.out.println(T.class);

        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        System.out.println(strings.getClass());
        System.out.println(integers.getClass());
        System.out.println(strings.getClass() == integers.getClass());

        List<? extends Number> numbers = new ArrayList<>();
        System.out.println(numbers.getClass());
        System.out.println(integers.getClass() == numbers.getClass());
    }
}
