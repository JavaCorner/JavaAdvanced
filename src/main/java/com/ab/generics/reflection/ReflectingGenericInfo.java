package com.ab.generics.reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class ReflectingGenericInfo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Class<? extends List> arrayListClass = strings.getClass();

        System.out.println(arrayListClass.toString());
        System.out.println(arrayListClass.toGenericString());

        TypeVariable<? extends Class<? extends List>>[] typeParameters = arrayListClass.getTypeParameters();
        System.out.println(Arrays.toString(typeParameters));

        ParameterizedType genericSuperclass = (ParameterizedType) StringList.class.getGenericSuperclass();
        System.out.println(Arrays.toString(genericSuperclass.getActualTypeArguments()));
    }

    private static class StringList extends ArrayList<String>{

    }
}
