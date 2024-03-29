package com.ab.generics.erasure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author Arpit Bhardwaj
 *
 * Compiler adds bridge synthetic method for backword compatability
 */
//original source code
public class Legacy implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        return s;
    }

    public static void main(String[] args) {
        Legacy e = new Legacy();
        String apply = e.apply("");
    }
}

/*
//Compiled Code

public class Legacy implements UnaryOperator<String> {
    @Override
    public String apply(final String s) {
        return s;
    }

    //bridge synthetic method generated by compiler
    public Object apply(final Object o){
        return this.apply((String o));
    }

}
 */
