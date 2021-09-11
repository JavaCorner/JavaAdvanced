package com.ab.generics.wildcard;


import java.io.IOException;
import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * Arrays are covariant which result in runtime exceptions (ArrayStoreException)
 *      an array of type T[] may contain elements of type T or any subtype of T.
 *      an array S[] is a subtype of the array T[] if S is a subtype of T
 *
 * Arrays are of Refiable Type
 *
 * All Collection API uses generics that are invariant; code validate at compile time
 */
public class VarianceDemo {
    public static void main(String[] args) {
        Number[] numbers = new Number[3];
        //Integer, Float, Double are subtype of Number
        numbers[0] = 10;
        numbers[1] = 11.5F;
        numbers[2] = 3.2;

        System.out.println(Arrays.toString(numbers));

        Integer[] integers = new Integer[3];
        Number[] numbers2 = integers;
        //numbers2[0] = 3.2;                //throws ArrayStoreException

        List<Integer> integers3 = new ArrayList<>();
        integers3.add(1);
        integers3.add(2);
        //List<Number> myNums = integers;   //compiler error

        //we can bypass the generics' compiler check in collection using raw types, which can result in runtime exception
        List myInts = integers3;
        List<Number> myNums = myInts;
        myNums.add(12L);
        //Integer integer = integers3.get(2);//throws ClassCastException

        //due to above behavior of generics in collection we are losing the power of polymorphism
        //In order to overcome above limitation and support polymorphism in generic world
        //generics came up with the concept of covariance and contravariance.

        List<Exception> list = new ArrayList<>();
        list.add(new RuntimeException());
        list.add(new Exception());

        getCoExceptions(list);
        getContraExceptions(list);
    }

    //covariance (upper bound)
    //read, but not write.
    //Reading is possible because whatever the actual list contains, it can be upcasted to a Number
    //Adding not allowed because the compiler cannot determine what is the actual type of the object in the generic structure
    //can get Exception and any class who extends Exception
    public static void getCoExceptions(List<? extends Exception> coll) {
        //coll.add(new IOException());                //compile error

        Exception e = coll.get(0);
        System.out.println(e.getClass());

        coll.forEach(x-> System.out.println(x.getClass()));
    }

    //contravariance (lower bound)
    //(write, but cannot read to specific type)
    //can put Exception and any class whose ancestor is Exception
    public static void getContraExceptions(List<? super Exception> coll) {
        coll.add(new IOException());

        Object o = coll.get(0);
        System.out.println(o.getClass());
        //Exception e = coll.get(0);                //compile error

        coll.forEach(x-> System.out.println(x.getClass()));
    }
}
