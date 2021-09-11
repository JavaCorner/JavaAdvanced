package com.ab.generics.limitation;

import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 * You cannot overloads methods by changing generic information only
 */
public class Overloading {
    public void print (String param){}
    public void print (Integer param){}
    public void print (List<String> param){}

    //public void print (List<Integer> param){}         // DOES NOT COMPILE
    //public void print (List<List<Integer>> param){}   // DOES NOT COMPILE
}
