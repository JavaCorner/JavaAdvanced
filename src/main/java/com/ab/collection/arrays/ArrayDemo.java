package com.ab.collection.arrays;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //initialization
        int[] ids = new int[10];
        //int[] ids = new int[]{1,2,3,4,5};
        //int[] ids = {1,2,3,4,5};  //anonymous array

        //you can type the [] before or after the name, and adding a space is optional.
        //int []ids = new int[10];
        //int [] ids = new int[10];
        //int ids[] = new int[10];
        //int ids [] = new int[10];

        //int[] ids;                //not valid as down in when we use it and compiler will complain
        //int[] ids = new int[0];   //valid create an array of length 0
        int[] ids1;                 //valid as we are not using this in the code
        int[] ids2,ids3;

        //Accessing and Iteration
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i+1;
            System.out.print(ids[i]);
        }

        System.out.println();

        for (int id: ids) {
            System.out.print(id);
        }

        System.out.println();
    }
}
