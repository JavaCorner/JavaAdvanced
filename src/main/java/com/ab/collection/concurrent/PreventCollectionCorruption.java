package com.ab.collection.concurrent;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Arpit Bhardwaj
 *
 * Unmodifiable (fast but read only)
 * Synchronized (slow and unscalable)
 * Copy on write (fast, but consumes memory)
 *
 * Legacy collection classes are by default all syncronized, which has performnce issue
 * New Collection classes are by default thread unsafe
 *
 * ArrayList is the new equivalent for legacy Vector
 * HashMap is the new equivalent for legacy HashTable
 */

public class PreventCollectionCorruption {
    public static void main(String[] args) {
        Map<Integer,String> map = Collections.synchronizedMap(new HashMap<>());
        Set<String> set = Collections.unmodifiableSet(new HashSet<>());
        List<String> list = new CopyOnWriteArrayList<>(new ArrayList<>());
    }
}
