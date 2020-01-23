package com.ab.generics.erasure;

import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class Erasure<T,B extends Comparable<B>> {
    public void unBounded(T param){

    }
    public void lists(List<String> param1, List<List<T>> param2){

    }
    public void bounded(B param){

    }
}
