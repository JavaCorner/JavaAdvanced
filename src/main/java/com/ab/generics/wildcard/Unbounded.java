package com.ab.generics.wildcard;

import com.ab.generics.model.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class Unbounded {

    public static void main(String[] args) {
        //List objects = new ArrayList();
        //List objects = new ArrayList(     );
        //List objects = new ArrayList<>();
        //List objects = new ArrayList<  >(    );
        //List objects = new ArrayList<  Object   >(    );

        //List<> objects = new ArrayList();//not allowed

        //List<Object> objects = new ArrayList();
        List<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add("abc");
        objects.add(new Object());
        objects.add(new Person("Nish", 28));
        System.out.println(objects);


        //the only value pass through ? is null
        List<?> objects2 = new ArrayList<>();
        objects2.add(null);
        //Compile time error
        //objects2.add(1);
        //objects2.add("abc");
        //objects2.add(new Object());
        //objects2.add(new Person("Nish", 28));
        System.out.println(objects2);

        //As adding use contravariance
        List<? super Object> objects3 = new ArrayList<>();
        objects3.add(new Object());
        objects3.add(new Person("Nish", 28));
        System.out.println(objects3);

        //var objects4 = new HashSet<?>();//not allowed
        //var objects4 = new HashSet<String>();//allowed
        var objects4 = new HashSet<>();//implicit object type inferred
        objects4.add(1);
        objects4.add("abc");
        objects4.add(new Object());
        objects4.add(new Person("Nish", 28));
        System.out.println(objects4);


    }
}
