package com.ab.generics.classes_and_interfaces;

public class SortedPair<T extends Comparable<T>> {
    private final T first;
    private final T second;

    public SortedPair(T left, T right) {
        //if(left.compareTo(right)<0){ //runtime error
        if(left.compareTo(right)<0){
            this.first = left;
            this.second = right;
        }else{
            first = right;
            second = left;
        }
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
