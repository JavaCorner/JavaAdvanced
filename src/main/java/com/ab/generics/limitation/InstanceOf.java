package com.ab.generics.limitation;

/**
 * @author Arpit Bhardwaj
 *
 * generics in instanceOf not allowed
 */
public class InstanceOf<T> {
    @Override
    public boolean equals(Object obj) {

        if(obj instanceof InstanceOf/*<T>*/){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        InstanceOf<String> obj1 = new InstanceOf<>();
        InstanceOf<String> obj2 = new InstanceOf<>();

        System.out.println(obj1.equals(obj2));
    }
}
