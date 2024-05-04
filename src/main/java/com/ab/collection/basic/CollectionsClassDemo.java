package com.ab.collection.basic;

import com.ab.collection.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 *
 */
public class CollectionsClassDemo {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(List.of(4, 8, 1, 3, 9));

        /******** sorting ********/
        Collections.sort(integerList);//throws UnsupportedOperationException in case of unmodifiable list
        System.out.println(integerList);

        /******** searching ********/
        System.out.println(Collections.binarySearch(integerList,10)); //(-(insertion point) - 1

        /******** misc ********/
        Collections.reverse(integerList);
        System.out.println(integerList);

        Collections.shuffle(integerList);
        System.out.println(integerList);

        List<Product> products = new ArrayList<>();
        Product floorPanel = new Product("Panel", 25);
        products.add(floorPanel);

        Collections.fill(products, new Product("Door",35));
        System.out.println(products);
    }
}
