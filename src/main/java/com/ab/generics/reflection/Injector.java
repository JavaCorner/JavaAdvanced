package com.ab.generics.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Arpit Bhardwaj
 */
public class Injector {

    private Map<Class<?>, Object> objectMap = new HashMap<>();

    public Injector put(Object obj){
        objectMap.put(obj.getClass(),obj);
        return this;
    }

    /*public Object newInstance(String className){
        return null;
    }*/

    /*public Object newInstance(Class<?> className){
        return null;
    }*/

    public <T> T newInstance(Class<T> className){
        /*if(objectMap.containsKey(className)){
            return (T) objectMap.get(className);
        }else{
            instantiate(className);
        }*/
        //using computeIfAbsent to perform in one line

        return (T) objectMap.computeIfAbsent(className,this::instantiate);
    }

    private <T> T instantiate(Class<T> className) {
        try {
            Constructor<?>[] constructors = className.getConstructors();
            if (constructors.length != 1) {
                throw new IllegalArgumentException(className + "must have only 1 constructor");
            }
            Constructor<?> constructor = constructors[0];

            Object[] objects = Stream.of(constructor.getParameterTypes())
                    .map(param -> (T) newInstance(param))
                    .toArray();


            return (T) constructor.newInstance(objects);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
           throw new RuntimeException();
        }
    }
}
