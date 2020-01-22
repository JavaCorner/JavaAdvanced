package com.ab.generics.wildcard;

import com.ab.generics.model.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver {
    private final RandomAccessFile file;

    public PersonSaver(final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file,"rw");
    }

    public void save(Person person) throws IOException {

        file.writeUTF(person.getClass().getName());
        file.writeUTF(person.getName());
        file.writeInt(person.getAge());
    }

    public void saveAll(Person[] persons) throws IOException {

        for (Person person: persons) {
            save(person);
        }
    }

    //while getting or extract things from list use extends
    //Covariance
    public void saveAll(List<? extends Person> persons) throws IOException {
        for (Person person: persons) {
            save(person);
        }
    }

    //this way also can be done by passing T in function but it becomes cluttered
    /*public <T extends Person> void saveAll(List<T> persons) throws IOException {
        for (T person: persons) {
            save(person);
        }
    }*/

}
