package com.ab.generics.advanced;

import com.ab.generics.model.Employee;
import com.ab.generics.model.Partner;
import com.ab.generics.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

/**
 * @author Arpit Bhardwaj
 */
public class LambdaExpression {

    public static void main(String[] args) {
        final Partner donDrapper = new Partner("Don Drapper", 89);
        final Employee peggyOlson = new Employee("Peggy Olson", 65);
        final Partner bertCooper = new Partner("Bert Cooper", 100);

        Predicate<Person> isOld = person -> person.getAge() > 80;
        System.out.println(isOld.test(donDrapper));
        System.out.println(isOld.test(peggyOlson));

        List<Person> personList = new ArrayList<>();
        personList.add(donDrapper);
        personList.add(peggyOlson);
        personList.add(bertCooper);

        Map<Boolean, List<Person>> collect = personList.stream()
                .collect(Collectors.partitioningBy(isOld));
        System.out.println(collect);

        Map<Boolean, Long> collect2 = personList.stream()
                .collect(Collectors.partitioningBy(isOld,counting()));
        System.out.println(collect2);
    }
}
