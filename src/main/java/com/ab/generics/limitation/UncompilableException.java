package com.ab.generics.limitation;

/**
 * Compile time error: Generic class may not extend 'java.lang.Throwable'
 * @author Arpit Bhardwaj
 */
public class UncompilableException/*<T>*/ extends Throwable {

    public static void main(String[] args) {
        try{
            throw new UncompilableException();
        }catch(UncompilableException/*<T>*/ e){
            e.printStackTrace();
        }
    }
}
