package com.ab.generics.erasure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class Legacy {
    public static void main(String[] args) {
        List list = new ArrayList();
        //not same as
        //List<Object> list = new ArrayList<>();

        list.add("abc");
        list.add(1);
        list.add(new Object());

        List<Integer> integers = new ArrayList();
        integers = list;
        List<String> strings = new ArrayList();
        //list = strings;

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Leads to ClassCastException
        for (Integer elem:integers) {
            System.out.println(elem);
        }
    }
}
