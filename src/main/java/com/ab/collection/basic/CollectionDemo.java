package com.ab.collection.basic;

import com.ab.collection.model.Product;

import java.util.*;

/**
 * @author Arpit Bhardwaj
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Product door = new Product("Door", 35);
        Product floorPanel = new Product("Panel", 25);
        Product window = new Product("Window", 10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        //System.out.println(products);

        //by iterator
        final Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()){
            Product product = productIterator.next();
            System.out.println(product);
        }

        //by for each loop
        for (Product product:products) {
            System.out.println(product);
        }

        //remove element while iterating can only be done using iterator
        final Iterator<Product> productIterator2 = products.iterator();
        while (productIterator2.hasNext()){
            Product product = productIterator2.next();
            if(product.getWeight() > 20){
                System.out.println(product);
            } else{
                productIterator2.remove();        //Removes from the underlying collection the last element returned by this iterator
                //products.remove(product);       //throw ConcurrentModificationException
            }
        }

        // for-each loop implicitly creates an iterator, but it is not exposed to the user.
        // so if you use a collection modifying methods then it throws ConcurrentModificationException
        try{
            for (Product product:products) {
                if(product.getWeight() > 30){
                    System.out.println(product);
                }
                else{
                    //products.remove(product); //throw ConcurrentModificationException
                    //products.clear();         //throw ConcurrentModificationException
                    //products.add(window);     //throw ConcurrentModificationException
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(products.size());            //2
        System.out.println(products.isEmpty());         //false
        System.out.println(products.contains(door));    //true
        System.out.println(products.contains(window));  //false

        Collection<Product> otherProducts = new ArrayList<>();
        otherProducts.add(window);
        otherProducts.add(door);

        System.out.println(products.containsAll(otherProducts));    //false
        products.removeAll(otherProducts);
        System.out.println(products);
    }
}
