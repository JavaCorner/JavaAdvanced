package com.ab.generics.basic;


//Allowed
public class NamingGeneric<C> {

    public <M> M test(M t){
        return null;
    }

    public <N> N test3(N t){
        return null;
    }
    public <M> M test4(C t){
        return null;
    }
    public <M> C test5(M t){
        return null;
    }
    //here C hides the C Type at class level
    public <C> C test2(C t){
        return null;
    }
}
//public class NamingGeneric<Object> {}
//public class NamingGeneric<String>{}
//public class NamingGeneric<NamingGeneric> {}

//not allowed
//public class NamingGeneric<?> {}

