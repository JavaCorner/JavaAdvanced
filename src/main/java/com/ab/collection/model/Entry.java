package com.ab.collection.model;

/**
 * @author Arpit Bhardwaj
 *
 * Data Dtructure for Custom Hash Map
 */
public class Entry<K,V> {
    K key;
    V value;
    Entry<K,V> next;
    Entry<K,V> before;//used for linked hash map
    Entry<K,V> after;//used for linked hash map

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Entry getNext() {
        return next;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
