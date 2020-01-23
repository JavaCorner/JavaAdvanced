package com.ab.generics.limitation;

/**
 * @author Arpit Bhardwaj
 */
public class InstanceOf<T> {
    @Override
    public boolean equals(Object obj) {
        //generics in instanceOf not allowed
        if(obj instanceof InstanceOf/*<T>*/){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new InstanceOf<>() instanceof Object);
    }
}
