package com.ab.generics.collections;

import com.ab.generics.model.Person;

import java.util.HashMap;
import java.util.Map;

public class MapExamples {
    public static void main(String[] args) {
        Person donDrapper = new Person("Don Drapper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        Map<String, Person> madMen = new HashMap<>();
        madMen.put(donDrapper.getName(),donDrapper);
        //madMen.put(donDrapper.getName(),peggyOlson);//override the value in the key
        madMen.put(peggyOlson.getName(),peggyOlson);
        madMen.put(bertCooper.getName(),bertCooper);

        System.out.println(madMen);

        for (String name:madMen.keySet()) {
            System.out.println(name);
        }

        for (Person person:madMen.values()) {
            System.out.println(person);
        }

        for (Map.Entry<String,Person> entry:
             madMen.entrySet()) {
            //System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
