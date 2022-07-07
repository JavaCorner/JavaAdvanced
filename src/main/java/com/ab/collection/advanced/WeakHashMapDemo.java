package com.ab.collection.advanced;

import java.util.Date;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Arpit Bhardwaj
 *
 * WeakHashMap is an implementation of the Map interface that stores only weak references to its keys.
 * Storing only weak references allows a key-value pair to be garbage-collected when its key is no longer referenced outside of the WeakHashMap.
 *
 * It is useful for implementing "registry-like" data structures
 */


public class WeakHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        final Map<Person,PersonMetaData> weakMap = new WeakHashMap<>();
        Person p = new Person();
        weakMap.put(p,new PersonMetaData());

        System.out.println(weakMap.toString());
        p = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println(weakMap.toString());
    }
}

final class Person{

}

class PersonMetaData{
    Date date;

    public PersonMetaData() {
        date = new Date();
    }

    @Override
    public String toString() {
        return "PersonMetaData{" +
                "date=" + date +
                '}';
    }
}
