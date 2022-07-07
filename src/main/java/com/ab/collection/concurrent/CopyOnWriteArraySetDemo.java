package com.ab.collection.concurrent;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Arpit Bhardwaj
 *
 * Iterator of CopyOnWriteArraySet class can perform only read operation
 * removal operation on iterator, throws java.lang.UnsupportedOperationException
 */
public class CopyOnWriteArraySetDemo {

    static class Publisher{
        private CopyOnWriteArraySet<Subscriber> threadSafeSetSub = new CopyOnWriteArraySet<>();

        public void addSubscriber(Subscriber subscriber){
            threadSafeSetSub.add(subscriber);
        }

        public void notifySubscribers(String score){
            Iterator<Subscriber> iterator = threadSafeSetSub.iterator();
            while (iterator.hasNext()){
                iterator.next().receive(score);
            }
        }
    }

    static class Subscriber{

        private String name;

        public Subscriber(String name) {
            this.name = name;
        }

        public void receive(String score) {
            System.out.println("Score Received : " + score + " by subscriber : " + name);
        }
    }

    public static void main(String[] args) {
        Publisher cricPublisher = new Publisher();
        Subscriber sub1 = new Subscriber("Raj");
        Subscriber sub2 = new Subscriber("Vinay");

        cricPublisher.addSubscriber(sub1);
        cricPublisher.addSubscriber(sub2);

        cricPublisher.notifySubscribers("Six");
        cricPublisher.notifySubscribers("Four");
    }
}

