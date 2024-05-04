package com.ab.collection.basic;

import com.ab.collection.custom.CustomImmutableList;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class ImmutableCollections {
    public static void main(String[] args) {

        List<Integer> readOnlyList1 = List.of(4, 8, 1, 3, 9);       //Returns an unmodifiable list
        //readOnlyList1.add(6);               //throws UnsupportedOperationException

        List<String> list = new ArrayList<>();
        list.add("raj");
        List<String> readOnlyList2 = Collections.unmodifiableList(list);
        //readOnlyList2.add("simran");     //throws UnsupportedOperationException

        Set<String> readOnlySet = new HashSet<>();
        readOnlySet = Collections.unmodifiableSet(readOnlySet);
        //readOnlySet.add("set");       //throws UnsupportedOperationException

        Map<String,Integer> readOnlyMap = new HashMap<>();
        readOnlyMap = Collections.unmodifiableMap(readOnlyMap);
        //readOnlyMap.put("one",1);     //throws UnsupportedOperationException
    }
}
