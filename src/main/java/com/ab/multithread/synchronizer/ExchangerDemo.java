package com.ab.multithread.synchronizer;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Arpit Bhardwaj
 *
 * Exchanger facilitates the exchange of elements between a pair of threads by creating a synchronization point.
 * It simplifies the exchange of data between two threads.
 */
public class ExchangerDemo {
    static public class ProduceString implements Runnable{
        private Exchanger<String> exchanger;
        private String str;

        public ProduceString(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            this.str = new String();

            new Thread(this).start();
        }

        @Override
        public void run() {
            char ch = 'A';
            try {
                for (int i = 0; i < 3; i++) {
                    //build string
                    for (int j = 0; j < 5; j++) {
                        str += ch++;
                    }
                    if (i==2){
                        str = exchanger.exchange(str,250, TimeUnit.MILLISECONDS);
                    }
                    System.out.println("Sending String : " + str);
                    //exchange string
                    str = exchanger.exchange(str);
                }
            }
            catch (InterruptedException | TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
    static public class ConsumeString implements Runnable{
        private Exchanger<String> exchanger;
        private String str;

        public ConsumeString(Exchanger<String> exchanger) {
            this.exchanger = exchanger;

            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    if (i==2){
                        Thread.sleep(500);
                        continue;
                    }

                    // Exchange an empty string with a filled one
                    str = exchanger.exchange(new String());
                    System.out.println("Received String : " + str);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new ProduceString(exchanger);
        new ConsumeString(exchanger);
    }
}
