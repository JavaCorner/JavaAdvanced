package com.ab.generics.erasure;

import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 * Compiler earses information about generics from compiled code.
 *      compiler verifies type safety of your code before erasing generics
 *      compiler add relevant typecasting operations
 */

//original source code
public class Erasure<T> {
    public T apply(T t){
        return t;
    }
    public static void main(String[] args) {
        Erasure<String> e = new Erasure<>();
        String apply = e.apply("");
    }
}

/*
//Compiled Code

public class Erasure {
    public Object apply(Object t){
        return t;
    }
    public static void main(String[] args) {
        Erasure<String> e = new Erasure<>();
        String apply = (String) e.apply("");
    }
}
 */





