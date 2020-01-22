package com.ab.generics.wildcard;

import com.ab.generics.model.Person;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PersonLoader {
    private final RandomAccessFile file;

    public PersonLoader(final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file,"rw");
    }
    public Person load() throws ClassNotFoundException {
        /*int age = file.readInt();
        String name = file.readUTF();
        Person person = new Person(name, age);*/

        /*FileInputStream fis = new FileInputStream(String.valueOf(file));
        ObjectInputStream iis = new ObjectInputStream(new BufferedInputStream(fis));
        Object obj = iis.readObject();
        return (Person) obj;*/

        try {
            final String className = file.readUTF();
            final String personName = file.readUTF();
            final int age = file.readInt();
            final Class<?> personClass = Class.forName(className);
            final Constructor<?> personClassConstructor = personClass.getConstructor(String.class, int.class);
            return (Person) personClassConstructor.newInstance(personName,age);
        }
        catch (IOException e) {
            return null;
            //e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*public void loadAll(List<Person> persons) throws ClassNotFoundException {
        Person person;

        while ((person = load()) != null){
            persons.add(person);
        }
    }*/

    //when putting things in list use super
    //Contra variance
    public void loadAll(List<? super Person> persons) throws ClassNotFoundException {
        Person person;

        while ((person = load()) != null){
            persons.add(person);
        }
    }
}
