package com.ab.generics.wildcard;

import com.ab.generics.model.Employee;
import com.ab.generics.model.Partner;
import com.ab.generics.model.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersonStorageTest {
    private Partner donDrapper = new Partner("Don Drapper", 89);
    private Employee peggyOlson = new Employee("Peggy Olson", 65);
    private Partner bertCooper = new Partner("Bert Cooper", 100);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    @Test
    public void saveAndLoadsPerson() throws IOException, ClassNotFoundException {
        /*Person person = new Person("bob", 20);
        saver.save(person);
        assertEquals(person, loader.load());*/

        saver.save(donDrapper);
        assertEquals(donDrapper,loader.load());

        saver.save(peggyOlson);
        assertEquals(peggyOlson,loader.load());
    }

    @Test
    public void saveAndLoadsArraysOfPeople() throws IOException, ClassNotFoundException {
        /*Person[] person = new Person[2];
        person[0] = donDrapper;
        person[1] = bertCooper;

        saver.saveAll(person);*/

        //Arrays are covariants
        /*Partner[] partners = new Partner[2];
        Person[] persons = partners;
        partners[0] = donDrapper;
        partners[1] = bertCooper;

        saver.saveAll(partners);*/

        /*Partner[] partners = new Partner[2];
        Person[] persons = partners;
        persons[0] = donDrapper;
        persons[1] = bertCooper;

        saver.saveAll(persons);*/

        //Arrays are type unsafe leads to ArrayStoreException
        /*Employee[] employees = new Employee[2];
        Person[] persons = employees;
        persons[0] = donDrapper;
        persons[1] = bertCooper;

        saver.saveAll(persons);*/

        /*List<Person> persons = new ArrayList<>();
        persons.add(donDrapper);
        persons.add(bertCooper);

        saver.saveAll(persons);*/

        //Leads to compile time error in order to remove use upper bounded wildcards in saveAll method
        List<Partner> persons = new ArrayList<>();
        persons.add(donDrapper);
        persons.add(bertCooper);

        saver.saveAll(persons);


        assertEquals(donDrapper, loader.load());
        assertEquals(bertCooper,loader.load());
    }

    @Test
    public void loadListsOfPeople() throws Exception{
        saver.save(donDrapper);
        saver.save(peggyOlson);

        /*List<Person> persons = new ArrayList<>();
        loader.loadAll(persons);*/

        /*List<Partner> partners = new ArrayList<>();
        loader.loadAll(partners);*/

        List<Object> persons = new ArrayList<>();
        loader.loadAll(persons);

        assertEquals(donDrapper, persons.get(0));
        assertEquals(peggyOlson,persons.get(1));
    }

    @Before
    public void setUp() throws Exception {
        file = File.createTempFile("tmp", "people");
        saver = new PersonSaver(file);
        loader = new PersonLoader(file);
    }

    @After
    public void tearDown() throws Exception {
        if (file.exists()){
            file.delete();
        }
    }
}