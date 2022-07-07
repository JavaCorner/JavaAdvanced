package com.ab.collection.enumbased;

import java.util.EnumMap;
import java.util.Iterator;

/**
 * @author Arpit Bhardwaj
 *
 * All keys used in EnumMap must be  from same Enum type which is specified while creating EnumMap
 *
 * Iterator returned by EnumMap traverse the elements in their natural order. As the elements are enum constants hence their natural order defines
 * the order on which enum constants are declared under enum class, or the order returned by ordinal() method.
 * An EnumMap iterator is weakly consistent and never throws ConcurrentModificationException
 *
 * EnumMap works on similar principles, but it uses Object[] to store values while key (index) is implicitly inferred from Enum.ordinal().
 */
public class EnumMapDemo {
    public enum State{
        NEW,RUNNING,WAITING,FINISHED;
    }

    public static void main(String[] args) {
        EnumMap<State,String> stateMap = new EnumMap<>(State.class);

        stateMap.put(State.FINISHED,"finished state");
        stateMap.put(State.RUNNING,"running state");
        stateMap.put(State.WAITING,"waiting state");
        stateMap.put(State.NEW,"new state");

        System.out.println(stateMap);
        System.out.println("Size of state enum map : " + stateMap.size());

        Iterator<State> stateIterator = stateMap.keySet().iterator();

        while (stateIterator.hasNext()){
            State state = stateIterator.next();
            System.out.println("Key : "
                    + state
                    + " Value : "
                    + stateMap.get(state));
        }
    }
}
