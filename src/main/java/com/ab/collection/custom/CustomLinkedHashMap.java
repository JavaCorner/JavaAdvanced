package com.ab.collection.custom;

import com.ab.collection.model.Entry;

/**
 * @author Arpit Bhardwaj
 */
public class CustomLinkedHashMap<K, V> {
    private int DEFAULT_BUCKET_COUNT = 10;

    private Entry<K, V>[] buckets;

    public CustomLinkedHashMap() {
        buckets = new Entry[DEFAULT_BUCKET_COUNT];
    }

    public Entry<K, V> get(K key){
        return null;
    }

    public void put(K key, V value){}

    public static void main(String[] args) {

    }
}
