package com.ab.generics.basic;

public class TypeSafeExample {
    public static void main(String[] args) {
        GenericCircularBuffer<String> buffer = new GenericCircularBuffer<>(10);
        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        //buffer.offer(1); //compile time error
        String value = concatenate(buffer);
        System.out.println(value);
    }

    private static String concatenate(GenericCircularBuffer<String> buffer) {
        StringBuilder result = new StringBuilder();
        String value;
        while((value = buffer.poll()) != null){
            result.append(value);
        }
        return result.toString();
    }
}
