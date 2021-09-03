package com.ab.generics.reflection;

import java.util.ArrayList;
import java.util.List;

/**
 * Types that are reifiable can be reflected
 * Primitives
 * Non parameterized class/interface
 * All type arguments unbounded wildcards
 * Raw Types
 * Arrays
 *
 * @author Arpit Bhardwaj
 */
public class ReifiableTypes {
    public static void main(String[] args) {
        System.out.println(int.class);
        System.out.println(Integer.class);

        List<?> wildcardList = new ArrayList<>();
        System.out.println(wildcardList.getClass());

        List rawList = new ArrayList();
        System.out.println(rawList.getClass());

        System.out.println(wildcardList.getClass() == rawList.getClass());

        System.out.println(int[].class);
        System.out.println(List[].class);
        //System.out.println(int[].class == List[].class);

    }
}
