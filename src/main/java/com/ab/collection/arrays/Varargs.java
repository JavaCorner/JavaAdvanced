package com.ab.collection.arrays;

/**
 * @author Arpit Bhardwaj
 *
 * In methods accepting varargs parameter, you can pass arrays or directly comma separated elements
 */
public class Varargs {
    //valid
    /*public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
    }*/

    //valid
    /*public static void main(String args[]) {
        System.out.println(Arrays.toString(args));
    }*/
    //valid
    public static void main(String... args) {
        System.out.println(args.length);
        //System.out.println(args[0]);//throws ArrayIndexOutOfBoundsException for invalid index
        args = new String[10];
        System.out.println(args.length);


        walk(1);                     // 0
        walk(1, 2);           // 1
        walk(1, 2, 3);        // 2
        walk(1, new int[] {4, 5});  // 2
        //walk(1,null);        // throws NullPointerException in walk

        //varargs can only be used as a method parameter.
        //String... s = "";             //compile error
    }

    public static void walk(int start, int... nums) {
        System.out.println(nums.length);
    }

}
