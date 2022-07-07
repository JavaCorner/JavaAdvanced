package com.ab.collection.sort;

import com.ab.collection.util.Utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Arpit Bhardwaj
 *
 * Task 1: sort a HashMap by its key (if key implements comparable and if not) in natural order i.e. asending.
 * Task 2: sort a HashMap by its key (if key implements comparable and if not) in descending.
 */
public class SortHashMapByKey {
    public static void main(String[] args) {
        SortHashMapByKey sortHashMapByKey = new SortHashMapByKey();
        Map<String, Integer> hashMap = new HashMap<>();

        // putting values in the Map
        hashMap.put("Jayant", 81);
        hashMap.put("Abhishek", 90);
        hashMap.put("Anushka", 84);
        hashMap.put("Amit", 75);
        hashMap.put("Danish", 40);

        Utils.printMap(hashMap);

        //Convert HashMap to TreeMap.It will be sorted in natural order (ascending).
        Map<String, Integer> treeMap1 = new TreeMap<>(hashMap);
        Utils.printMap(treeMap1);

        //using putAll Method
        Map<String, Integer> treeMap2 = new TreeMap<>();
        treeMap2.putAll(hashMap);
        Utils.printMap(treeMap2);

        //descending order
        Map<String, Integer> treeMap3 = new TreeMap<>(Collections.reverseOrder());
        treeMap3.putAll(hashMap);
        Utils.printMap(treeMap3);
    }


}
