package com.ab.collection.sort;

import com.ab.collection.util.Utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Arpit Bhardwaj
 *
 * A TreeMap is always sorted based on its keys,
 * however if you want to sort it based on its values then you can build a logic to do this using comparator.
 */
public class SortTreeMapByValue {

    public static void main(String[] args) {
        Map<String, String> treeMap = new TreeMap<>();

        treeMap.put("Key1", "Jack");
        treeMap.put("Key4", "Tom");
        treeMap.put("Key2", "Rick");
        treeMap.put("Key3", "Kate");
        treeMap.put("Key5", "Steve");

        //by default sorted by key natural ordering in ascending order
        Utils.printMap(treeMap);

        //sorting by keys in descending order
        Map<String, String> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());
        reverseSortedMap.putAll(treeMap);

        Utils.printMap(reverseSortedMap);

        //sort by value (Asc)
        Map sortedMapByValuesAsc = Utils.sortMapByValuesAsc(treeMap);
        Utils.printMap(sortedMapByValuesAsc);

        //sort by value (Dsc)
        Map sortedMapByValuesDsc = Utils.sortMapByValuesDsc(treeMap);
        Utils.printMap(sortedMapByValuesDsc);
    }


}
