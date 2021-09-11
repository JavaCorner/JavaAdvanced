package com.ab.generics.limitation;

/**
 * @author Arpit Bhardwaj
 *
 * Generic Exceptions are not allowed in java
 * means any class that extends throwable cannot be generic
 *
 */
public class UncompilableException/*<T>*/ extends Throwable {

    public static void main(String[] args) {
        try{
            throw new UncompilableException();
        }catch(UncompilableException e){
            e.printStackTrace();
        }
    }
}
