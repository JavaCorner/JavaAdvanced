package com.ab.generics.basic;

/**
 * @author Arpit Bhardwaj
 *
 * A Genric Type could be a word or a single letter
 */

//Allowed
public class NamingGeneric<ClassGeneric> {

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

    //here ClassGeneric hides the ClassGeneric Type at class level
    public <ClassGeneric> ClassGeneric test2(ClassGeneric t){
        return null;
    }
}
//public class NamingGeneric<Object> {}
//public class NamingGeneric<String>{}
//public class NamingGeneric<NamingGeneric> {}

//not allowed
//public class NamingGeneric<?> {}

