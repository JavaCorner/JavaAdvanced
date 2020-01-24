package com.ab.generics.advanced;

import com.ab.generics.model.Person;

import java.io.*;

/**
 * @author Arpit Bhardwaj
 */
public class IntersectionType {
    public static void main(String[] args) throws FileNotFoundException {
        IntersectionType intersectionType = new IntersectionType();

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/main/resources/person"));
        Person person = intersectionType.read(dataInputStream);

        RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/resources/person", "rw");
        person = intersectionType.read(randomAccessFile);

        System.out.println(person);
    }

    /*private Person read(DataInputStream source) {
        try(DataInputStream input = source){
            return new Person(input.readUTF(),input.readInt());
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }*/

    private <T extends DataInput & Closeable> Person read(T source) {
        try(T input = source){
            return new Person(input.readUTF(),input.readInt());
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
