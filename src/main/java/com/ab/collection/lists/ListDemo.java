package com.ab.collection.lists;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 *
 * List are indexed by position
 *                                                                              toArray()	Arrays.asList()	    List.of()
 * Type converting from	                                                        List	    Array (or varargs)	Array (or varargs)
 * Type created	                                                                Array	    List	            List
 * Allowed to remove values from created object	                                No	        No	                No
 * Allowed to change values in the created object	                            Yes	        Yes	                No
 * Changing values in the created object affects the original or vice versa.	No	        Yes	                N/A
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        //List list2 = new ArrayList();                     //valid
        //Collection list3 = new ArrayList();               //valid
        //ArrayList arrayList = new ArrayList();            //valid
        //ArrayList arrayList2 = new ArrayList(100);        //valid
        //ArrayList arrayList3 = new ArrayList(arrayList);  //valid

        //add() methods insert a new value in the ArrayList.
        //boolean add(E element)
        //void add(int index, E element)
        colors.add("yellow");
        colors.add("green");
        colors.add("orange");
        colors.add("violet");
        //add pushes the rest of elements forward in case you are adding at the existing index
        colors.add(1,"blue");
        //set method set actually updates the elements of the ArrayList without changing the size.
        colors.set(0,"red");
        //colors.set(7,"cyan");//throws IndexOutOfBoundsException
        //colors.add(7,"cyan");//throws IndexOutOfBoundsException
        System.out.println(colors);

        for (int i = 0; i < colors.size(); i++) {
            System.out.printf("%s ",colors.get(i));
        }
        System.out.println();

        for (String color:
             colors) {
            System.out.printf("%s ",color);
        }
        System.out.println();

        colors.forEach(c -> System.out.printf("%s ",c));
        System.out.println();

        colors.forEach(System.out::printf);
        System.out.println();

        //boolean remove(Object object)
        //E remove(int index)
        colors.remove("blue");
        colors.remove(1);
        colors.remove("cyan");       //return false
        //colors.remove(10);            //throws IndexOutOfBoundsException

        colors.forEach(c -> System.out.printf("%s ",c));
        System.out.println();

        //will not remove all elements and the size() is dynamic
        /*for (int i = 0; i < colors.size(); i++) {
            colors.remove(i);
        }

        colors.forEach(c -> System.out.printf("%s ",c));
        System.out.println();*/

        //to remove all elements use below approach
        /*int n = colors.size();
        for (int i = 0; i < n; i++) {
            colors.remove(0);
        }

        colors.forEach(c -> System.out.printf("%s ",c));
        System.out.println();*/

        //throw ConcurrentModificationException
        /*for (String color:
                colors) {
            colors.remove(color);
        }

        //to avoid ConcurrentModificationException iterate on copy of it
        List<String> copyList = new ArrayList<>(colors);
        for (String color:
                copyList) {
            colors.remove(color);
        }

        System.out.println();
        colors.forEach(c -> System.out.printf("%s ",c));*/

        /******** ArrayList to Array ********/
        Object[] colorsArr = colors.toArray();
        System.out.println(Arrays.toString(colorsArr));

        String[] colorsArr2 = new String[2];
        colorsArr2 = colors.toArray(colorsArr2); //increase array length to accommodate all list elements
        System.out.println(Arrays.toString(colorsArr2));

        //clear() method provides an easy way to discard all elements of the ArrayList.
        colors.clear();
        System.out.println(colors);

        /******** Array to ArrayList ********/
        String[] shapes = new String[]{"square","circle","rectangle"};

        //returns a semi immutable fixed size list whose length is equal to length of passed array
        //also known as a backed List because the array changes with it.
        //swap an element is allowed, no addition and deletion
        List<String> shapesList = Arrays.asList(shapes);//receives varargs so you can pass array as well elements directly comma separated
        shapesList.set(1,"hexagon");
        //shapesList.add("hexagon");    //throws UnsupportedOperationException
        //shapesList.remove("circle");  //throws UnsupportedOperationException

        Collections.sort(shapesList);   //sorting works
        System.out.println(shapesList);
        System.out.println(Arrays.toString(shapes));
        System.out.println(shapesList.getClass().getName());

        //return a complete immutable list
        List<String> shapesList2 = List.of(shapes);
        //Collections.sort(shapesList2);     // throws UnsupportedOperationException
        System.out.println(shapesList2);
        System.out.println(shapesList2.getClass().getName());
        //shapesList2.set(1,"hexagon");     // throws UnsupportedOperationException
        //shapesList2.add("hexagon");       // throws UnsupportedOperationException
        //shapesList2.remove("circle");     // throws UnsupportedOperationException

        //to get actual list, need to do old school method
        List<String> shapeList3 = new ArrayList<>();

        for (String shape:
             shapes) {
            shapeList3.add(shape);
        }

        System.out.println(shapeList3);
        System.out.println(shapeList3.getClass().getName());

        //linked list is the implementation of list and queues
        LinkedList<String> orders = new LinkedList<>();
        orders.add("o1");
        orders.add("o2");
        orders.add("o3");
        System.out.println(orders.get(1));

        //methods come from queues
        orders.addFirst("o4");
        orders.addLast("o5");
        orders.removeFirst();
        orders.removeLast();
        System.out.println(orders);
    }
}
