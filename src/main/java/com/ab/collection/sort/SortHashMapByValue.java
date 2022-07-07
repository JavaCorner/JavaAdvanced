package com.ab.collection.sort;

import com.ab.collection.util.Utils;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 *  Task 1: sort a HashMap by its values (if key implements comparable and if not) in natural order i.e. asending.
 *  Task 2: sort a HashMap by its values (if key implements comparable and if not) in descending.
 */
public class SortHashMapByValue {
    public static void main(String[] args) {
        SortHashMapByValue sortHashMapByVaue = new SortHashMapByValue();
        Map<String, Integer> hashMap = new HashMap<>();

        // putting values in the Map
        hashMap.put("Jayant", 81);
        hashMap.put("Abhishek", 90);
        hashMap.put("Anushka", 84);
        hashMap.put("Amit", 75);
        hashMap.put("Danish", 40);

        Map<String,Integer> sortedMapByValueAsc = Utils.sortMapByValuesAsc(hashMap);
        Utils.printMap(sortedMapByValueAsc);

        Map<String,Integer> sortedMapByValueDsc = Utils.sortMapByValuesDsc(hashMap);
        Utils.printMap(sortedMapByValueDsc);

        Map<String,Integer> sortedMapByValueUsingListAsc = Utils.sortMapByValuesUsingListAsc(hashMap);
        Utils.printMap(sortedMapByValueUsingListAsc);

        Map<String,Integer> sortedMapByValueUsingListDsc = Utils.sortMapByValuesUsingListDsc(hashMap);
        Utils.printMap(sortedMapByValueUsingListDsc);
    }

}
