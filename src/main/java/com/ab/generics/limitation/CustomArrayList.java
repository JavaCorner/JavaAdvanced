package com.ab.generics.limitation;

import java.util.AbstractList;

/**
 * @author Arpit Bhardwaj
 */
public class CustomArrayList extends AbstractList {
    private Object[] values;

    public CustomArrayList() {
        this.values = new Object[0];
    }

    @Override
    public Object get(int index) {
        return values[index];
    }

    public boolean add(Object o){
        Object[] newValues = new Object[size() + 1];
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
