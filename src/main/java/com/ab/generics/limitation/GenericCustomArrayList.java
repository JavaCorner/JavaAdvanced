package com.ab.generics.limitation;

import java.util.AbstractList;

/**
 * Solution 1: to cast Object arrays to generic T[]
 * Solution 2:
 * @author Arpit Bhardwaj
 */
public class GenericCustomArrayList<T> extends AbstractList<T> {
    private Object[] values;
    //private T[] values;//Solution 1

    public GenericCustomArrayList() {
        this.values = new Object[0];
        //this.values = (T[]) new Object[0];//Solution 1
    }

    @Override
    public T get(int index) {
        //return values[index];//Solution 2
        return (T) values[index];
    }

    public boolean add(T o){
        Object[] newValues = new Object[size() + 1];
        //T[] newValues = (T[]) new Object[size() + 1];//Solution 1
        for (int i = 0; i < size(); i++) {
            newValues[i] = values[i];
        }
        newValues[size()] = o;
        values = newValues;
        return true;
    }
    @Override
    public int size() {
        return values.length;
    }
}
