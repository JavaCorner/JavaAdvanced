package com.ab.collection.maps;

import com.ab.collection.model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Arpit Bhardwaj
 *
 * Contract:
 * If two objects are equal according to the equals method, then calling the hashCode method on each of the two objects must produce the same integer result.
 * It is not required that if two objects are unequal according to the equals method, then calling the hashCode method on each of the two objects must produce distinct integer results.
 * However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.
 */

public class HashCodeEqualsContract {
    static class Product{
        private final String name;
        private final int weight;

        public Product(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Product{ "+name+":"+weight+" }";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return weight == product.weight &&
                    Objects.equals(name, product.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, weight);
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product("P2",24);
        Product p2 = new Product("P1",14);
        Product p3 = new Product("P3",29);
        Map<Product,Integer> map = new HashMap<>();
        map.put(p1,1234);
        map.put(p2,2345);
        map.put(p3,3456);

        //if you implement only equals
        //default hasCode() impl returns distinct integer for distinct object
        //you will not able to retrieve what you have added as the logical equal products have different hashcode
        Product p4 = new Product("P2",24);
        System.out.println(map.get(p4));

        //if you implement only hashcode
        //default equals() impl returns true only if two objects had the same reference pointer
        //you can add duplicate keys which are logically equal
        Product p5 = new Product("P3",  29);
        map.put(p5,4567);

        for (Map.Entry<Product,Integer> e:
             map.entrySet()) {
            System.out.println(e.getKey() + " " +e.getValue());
        }

    }
}
