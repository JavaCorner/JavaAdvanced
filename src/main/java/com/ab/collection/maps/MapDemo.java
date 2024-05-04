package com.ab.collection.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Arpit Bhardwaj
 *
 * The right side of the for-each loop must be one of the following:
 *      A built-in Java array
 *      An object whose type implements java.lang.Iterable
 * Hence, Map is not supported in a for-each loop
 *
 * No arg constructor creates a set of initial capacity of 16 elements with Default Load Factor = 0.75 (75%)
 * Map is a combination of set and list
 * Keys is basically a set and values is basically a list
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map1 = new HashMap<>(20,0.85F);

        Map<Integer,String> map = Map.of(1,"str1",3,"str2",4,"str3"); //returns read only map

        for (Map.Entry entry:
             map.entrySet()) {
            System.out.printf("%d:%s ",entry.getKey(),entry.getValue());
        }
        System.out.println();

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.printf("%d:%s ",entry.getKey(),entry.getValue());
        }
        System.out.println();

        map.forEach((k,v) -> System.out.printf("%d:%s ",k,v));
        System.out.println();

        map.entrySet().stream()
                .forEach((e) -> System.out.printf("%d:%s ",e.getKey(),e.getValue()));
        System.out.println();

        map.keySet().stream()
                .forEach(k-> System.out.printf("%d ",k));
        System.out.println();

        map.values().stream()
                .forEach(v-> System.out.printf("%s ",v));
        System.out.println();

        //Map<Integer,String> map3 = Map.ofEntries();
    }
}
