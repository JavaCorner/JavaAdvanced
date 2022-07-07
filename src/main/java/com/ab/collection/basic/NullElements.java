package com.ab.collection.basic;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Arpit Bhardwaj
 *
 * List:    Allows multiple null elements
 * Set:     Allow single null element
 * Map:     Allow at most one null key but multiple null values.
 * TreeSet: Do not allow null values (as it is an ordered set and uses compareTo method internally)
 * TreeMap: Do not allow null keys but multiple null values are allowed
 * Hashtable & ConcurrentHashMap: Do not allow null keys or values is because of multi-threaded environment.
 * CopyOnWriteArrayList:    Allows multiple null elements
 * CopyOnWriteArraySet:     Allow single null element
 *
 * Below get method code breaks in multithreaded environment
 *
 * if (map.contains(key)) {
 *     return map.get(key);
 * } else {
 *     throw new KeyNotFoundException;
 * }
 */
public class NullElements {
    public static void main(String[] args) {
        addNullInList();
        addNullInSet();
        addNullInMap();

        addNullInTreeSet();
        addNullInTreeMap();

        addNullInHashTable();
        addNullInConcurrentHashMap();
        addNullInCopyOnWriteArrayList();
        addNullInCopyOnWriteArraySet();
    }

    private static void addNullInList() {
        List<Object> list = new ArrayList<>();
        list.add(null);
        list.add("string1");
        list.add(null);
        list.add(1);
        System.out.println("ArrayList : " + list);
    }

    private static void addNullInSet() {
        Set<Object> set = new HashSet<>();
        set.add(null);
        set.add("string1");
        set.add(null);
        set.add(1);
        System.out.println("Set : " + set);
    }

    private static void addNullInMap() {
        Map<Object,Object> map = new HashMap<>();
        map.put(null,null);
        map.put(null,"String1");//replace the above one
        map.put(null,"String2");//replace the above one
        map.put("String3",null);
        map.put("String4",null);
        System.out.println("HashMap: " + map);
    }

    private static void addNullInTreeSet() {
        Set<Object> set = new TreeSet<>();
        //set.add(null);        //throws NullPointerException
        set.add("string1");
        System.out.println("TreeSet : " + set);
    }

    private static void addNullInTreeMap() {
        Map<Object,Object> map = new TreeMap<>();
        //map.put(null,"String1");//throws NullPointerException
        map.put("String1",null);
        map.put("String2",null);
        System.out.println("TreeMap: " + map);
    }

    private static void addNullInConcurrentHashMap() {
        Map<Object,Object> map = new ConcurrentHashMap<>();
        //map.put(null,null);       //throws NullPointerException
        //map.put(null,"String1");  //throws NullPointerException
        //map.put("String3",null);  //throws NullPointerException
        map.put("key","value");
        System.out.println("ConcurrentHashMap : " + map);
    }

    private static void addNullInHashTable() {
        Hashtable<Object,Object> hashtable = new Hashtable<>();
        //hashtable.put(null,null);     //throws NullPointerException
        //hashtable.put(null,"String1");//throws NullPointerException
        //hashtable.put("String3",null);//throws NullPointerException
        hashtable.put("key","value");
        System.out.println("HashTable: " + hashtable);
    }

    private static void addNullInCopyOnWriteArrayList() {
        List<Object> list = new CopyOnWriteArrayList<>();
        list.add(null);
        list.add("string1");
        list.add(1);
        list.add(null);
        System.out.println("CopyOnWriteArrayList : " + list);
    }

    private static void addNullInCopyOnWriteArraySet() {
        Set<Object> set = new CopyOnWriteArraySet<>();
        set.add(null);
        set.add("string1");
        set.add(1);
        set.add(null);
        System.out.println("CopyOnWriteArraySet : " + set);
    }
}
