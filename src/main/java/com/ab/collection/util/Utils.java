package com.ab.collection.util;

import com.ab.collection.model.Worker;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class Utils {

    public static <K, V> void printMap(Map<K,V> map){
        for (Map.Entry<K,V> entry:
                map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " " + "Value : " + entry.getValue());
        }
        System.out.println();
    }

    public static <T> void printArray(T[] arr){
        for (T item:
                arr) {
            System.out.println(item);
        }
        System.out.println();
    }

    public static <K, V extends Comparable<V>> Map<K,V> sortMapByValuesAsc(final Map<K, V> map) {

        Comparator<K> valueComparator = new Comparator<K>() {
            @Override
            public int compare(K k1, K k2) {
                return map.get(k1).compareTo(map.get(k2));//sort values in ascending order
            }
        };

        Map<K,V> sortedByValues = new TreeMap<>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    public static <K, V extends Comparable<V>> Map<K,V> sortMapByValuesDsc(final Map<K, V> map) {

        Comparator<K> valueComparator = new Comparator<K>() {
            @Override
            public int compare(K k1, K k2) {
                return map.get(k2).compareTo(map.get(k1));//sort values in descending order
            }
        };

        Map<K,V> sortedByValues = new TreeMap<>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    public static <K,V extends Comparable<V>> Map<K,V> sortMapByValuesUsingListAsc(Map<K,V> map){
        //convert map to a List
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        //transfer sorted list to linked hash map
        Map<K, V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<K,V> entry:
                list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static <K,V extends Comparable<V>> Map<K,V> sortMapByValuesUsingListDsc(Map<K,V> map){
        //convert map to a List
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //transfer sorted list to linked hash map
        Map<K, V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<K,V> entry:
                list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
