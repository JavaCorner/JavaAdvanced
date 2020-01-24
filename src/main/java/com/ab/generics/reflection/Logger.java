package com.ab.generics.reflection;

/**
 * @author Arpit Bhardwaj
 */
public class Logger {
    private String value;

    public Logger(String value) {
        this.value = value;
    }

    public void log(){
        System.out.println(value);
    }
}
