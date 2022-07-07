package com.ab.collection.arrays;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * Method	                When arrays are the same	When arrays are different
 * Arrays.equals()	        true	                    false
 * Arrays.compare()	        0	                        positive or negative number
 * Arrays.mismatch()	    -1	                        Zero or positive index
 */

public class ArraysClassDemo {
    public static void main(String[] args) {
        String[] instruments = new String[]{"Guitar","drums","bass"};

        /******** sort ********/
        Arrays.sort(instruments);
        System.out.println(Arrays.toString(instruments));

        int[] fib = new int[]{0,1,5,2,3,1,8,13};
        Arrays.sort(fib);                   //uses Dual-Pivot Quicksort algorithm
        System.out.println(Arrays.toString(fib));
        //Arrays.parallelSort(fib);         //uses parallel merge sort

        /******** search ********/
        //Array should be sorted else it returns un deterministic result.
        //returns index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1).
        //if element is greater than all elements in array then -arr.length-1
        //if element is smaller than all elements in array then -0-1 = -1
        System.out.println(Arrays.binarySearch(fib,4)); //(-5-1) = -6

        /******** comparison ********/
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{1,2,3};
        System.out.println(arr1.equals(arr2));          //false
        System.out.println(arr1 == arr2);               //false
        System.out.println(Arrays.equals(arr1,arr2));   //true

        //smaller,equal,bigger comparison (Java 11 Addition)
        //compare do lexicographically comparison of array
        //0 if equal,-1 if arr1 is smaller, +1 if arr1 is larger
        //If both arrays are the same length and have the same values in each spot in the same order, return zero.
        //If all the elements are the same but the second array has extra elements at the end, return a negative number.
        //If all the elements are the same but the first array has extra elements at the end, return a positive number.
        //If the first element that differs is smaller in the first array, return a negative number.
        //If the first element that differs is larger in the first array, return a positive number.
        System.out.println(Arrays.compare(new int[]{1,2}, new int[]{1}));               //1
        System.out.println(Arrays.compare(new int[]{1,2}, new int[]{1,2}));             //0
        System.out.println(Arrays.compare(new int[]{1,2}, new int[]{1,2,3}));           //-1
        System.out.println(Arrays.compare(new int[]{2,3}, new int[]{1,3}));             //1
        System.out.println(Arrays.compare(new int[]{1,2}, new int[]{2,3}));             //-1

        //null < numbers < uppercase letters < lowercase letters
        System.out.println(Arrays.compare(new String[]{"abcd"}, new String[]{"ABCD"})); //32

        //mismatch() returns the index of the first element that is different.-1 if the arrays are equal
        System.out.println(Arrays.mismatch(new int[]{1,2}, new int[]{1,2,4}));          //2

        /******** copying ********/
        //Method 1
        /*System.arraycopy(<source array>,
                           <source position>,
                           <destination array>,
                           <destination position>
                           <length of content to copy from source>);*/


        //Method 2
        /*Arrays.copyOf(<source array>,
                        <new array length>);*/

        //Method 3
        /*Arrays.copyOfRange(<source array>,
                             <start position>,
                             <end position>);*/

        //all below declaration are valid
        //int[][] multi = new int[2][2];
        //int multi[][] = new int[2][2];
        //int[]  [] multi = new int[2][2];
        //int[][] multi = new int[2]     [2];
        //int[] multi   [] = new int[2][2];
        //int[] multi2d [], multi3d [][];  // a 2D AND a 3D array

        //asymmetric multidimensional array
        int [][] asymulti = new int[4][];
        asymulti[0] = new int[5];
        asymulti[1] = new int[3];
    }
}
