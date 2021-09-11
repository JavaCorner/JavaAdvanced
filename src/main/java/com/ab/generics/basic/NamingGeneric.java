package com.ab.generics.basic;

import java.util.HashSet;

/**
 * @author Arpit Bhardwaj
 *
 * A Genric Type could be a word or a single letter
 */


public class NamingGeneric<ClassGeneric,GenericX,Y,Number,Object> {
    //keep in mind that Number and Object are just words here do not get confused with class names
    public <MethodGeneric> MethodGeneric test(MethodGeneric t){
        return null;
    }

    public <N> N test3(N t){
        return null;
    }
    public <M> M test4(ClassGeneric t){
        return null;
    }
    public <M> ClassGeneric test5(M t){
        return null;
    }

    //here Number is just the generic type not the Number class
    public <M> Number test6(Number t){
        return null;
    }

    //here ClassGeneric hides the ClassGeneric Type at class level
    public <ClassGeneric> ClassGeneric test2(ClassGeneric t){
        return null;
    }

    public static void main(String[] args) {
    }
}
//public class NamingGeneric<Object> {}
//public class NamingGeneric<String>{}
//public class NamingGeneric<NamingGeneric> {}

//not allowed
//public class NamingGeneric<?> {}

