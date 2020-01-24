package com.ab.generics.reflection;

/**
 * @author Arpit Bhardwaj
 */
public class ClassLiteralsDemo {
    public static void main(String[] args) {
        Injector injector = new Injector();
        injector.put("Hello World");

        //cast required as the newInstance method is not generic
        //Logger logger = (Logger) injector.newInstance("Logger");

        //restricted the parameter type
        //Logger logger = (Logger) injector.newInstance(Logger.class);

        //with generic newInstance
        Logger logger = injector.newInstance(Logger.class);
        logger.log();
    }
}
