package com.ab.generics.limitation;

import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class CustomArrayListDemo {
    public static void main(String[] args) {
        //below code compiles fine but throws ArrayStoreException at runtime
        /*String[] strings = new String[3];
        Object[] objects = strings;//as arrays are covariant and Reified Type
        objects[0] = 1;*/

        //List customArrayList = new CustomArrayList();
        List<Integer> customArrayList = new GenericCustomArrayList<>();

        //customArrayList.add("abc");//compiler will not tell for raw type customArrayList

        customArrayList.add(0);
        customArrayList.add(1);
        customArrayList.add(2);

        System.out.println(customArrayList.get(0));
        System.out.println(customArrayList.get(1));
        System.out.println(customArrayList.get(2));
        //System.out.println(customArrayList.get(3));
    }
}
