package com.ab.generics.wildcard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 * Arrays Are Covariant in java means
 *
 * an array of type T[] may contain elements of type T or any subtype of T.
 * an array S[] is a subtype of the array T[] if S is a subtype of T
 *
 * Arrays are of Refiable Type
 */
public class CovariantArrays {
    public static void main(String[] args) {
        Number[] numbers = new Number[3];
        //Integer, Float, Double are subtype of Number
        numbers[0] = new Integer(10);
        numbers[1] = new Float(10);
        numbers[2] = new Double(3);

        System.out.println(Arrays.toString(numbers));

        Integer[] integers = new Integer[3];
        Number[] numbers2 = integers;

        //numbers2[0] = 3.2;//java.lang.ArrayStoreException

        System.out.println(Arrays.toString(numbers2));

        List<Integer> integers3 = new ArrayList<>();
        integers3.add(1);
        integers3.add(2);
        //List<Number> myNums = integers; //compiler error as generic types are non-reifiable

        //due to above behavior of generics in collection we are losing the power of polymorphism
        //In order to overcome above limitation and support polymorphism in generic world
        //generics came up with the concept of covariance and contravariance.

        //contra variance (upper bound) (read, but not write.)
        //number3 accepts elements of Number Type or any subclasses of Number
        List<? extends Number> numbers3 = new ArrayList<Integer>();
        Number n1 = numbers3.get(0);
        //numbers3.add(2);//compile error

        //covariance (lower bound) (write, but not read.)
        //number4 accepts elements of Integer Type or any super classes of Integer
        List<? super Integer> numbers4 = new ArrayList<Number>();
        //Number n2 = numbers4.get(0);//compile error
        numbers4.add(2);
        //numbers4.add(1.0);//compile error

    }
}
