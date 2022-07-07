package com.ab.collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Arpit Bhardwaj
 *
 * Fail-fast iterators throw an exception(ConcurrentModificationException) if the collection is modified while iterating over it.
 * Example: ArrayList iterator
 *
 * Fail-safe iterators means they will not throw any exception even if the collection is modified while iterating over it.
 * Example: CopyOnWriteArrayList iterator
 *
 * Downside of Fail-safe iterators
 * 1. They will not reflect the latest state of the collection.
 * 2. It requires extra memory as it clones the collection.
 */
public class FailSafeFailFast {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        List<Integer> copyArrayList = new CopyOnWriteArrayList<>();
        copyArrayList.add(1);
        copyArrayList.add(2);
        copyArrayList.add(3);

        failFastIterators(arrayList);
        failSafeIterators(copyArrayList);
    }

    private static void failFastIterators(List<Integer> arrayList) {
        Iterator<Integer> iterator = arrayList.iterator();

        //arrayList.remove(0);          //throws ConcurrentModificationException
        //iterator.remove();            //throws IllegalStateException

        while (iterator.hasNext()){
            Integer next = iterator.next();
            //arrayList.remove(next);     //throws ConcurrentModificationException

            /*If we remove/add the element using the remove() or add() of iterator instead of collection,
            then in that case no exception will occur. It is because the remove/add methods of iterators
            call the remove/add method of collection internally, and also it reassigns the expectedModCount to new modCount value.*/

            if (next == 1){
                iterator.remove();
            }
        }

        //modify collection in for each loop also throws ConcurrentModificationException
        for (Integer i: arrayList) {
            //arrayList.remove(i);
        }

        //classical for loop will not throw any exception on modification, but it will not remove all elements as size() is dynamic
        for (int i = 0; i < arrayList.size(); i++) {
            //arrayList.remove(i);
        }
        System.out.println(arrayList);
    }

    private static void failSafeIterators(List<Integer> arrayList) {
        Iterator<Integer> iterator = arrayList.iterator();
        //arrayList.remove(0);
        //iterator.remove(); //throws UnsupportedOperationException

        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next == 1){
                arrayList.remove(next);
            }
            /*if (next == 1){
                iterator.remove();//throws UnsupportedOperationException
            }*/
        }
        System.out.println(arrayList);
    }

}
