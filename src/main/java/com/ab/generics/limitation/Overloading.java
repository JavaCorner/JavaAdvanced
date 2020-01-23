package com.ab.generics.limitation;

import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class Overloading {
    public void print (String param){}
    public void print (Integer param){}
    public void print (List<String> param){}

    //cannot do
    //public void print (List<Integer> param){}
    //public void print (List<List<Integer>> param){}
}
