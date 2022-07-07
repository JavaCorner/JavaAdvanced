package com.ab.collection.custom;

import java.util.AbstractList;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class CustomImmutableList<T> extends AbstractList<T> {

    private List<T> employeeList;

    public CustomImmutableList(List<T> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public T get(int index) {
        return this.employeeList.get(index);
    }

    @Override
    public int size() {
        return this.employeeList.size();
    }
}
