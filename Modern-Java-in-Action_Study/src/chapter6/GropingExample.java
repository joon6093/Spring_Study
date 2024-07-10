package chapter6;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

public class GropingExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, "Female"),
                new Person("Bob", 25, "Male"),
                new Person("Charlie", 35, "Male"),
                new Person("Diana", 28, "Female"),
                new Person("Eve", 22, "Female"),
                new Person("Frank", 40, "Male"),
                new Person("Grace", 33, "Female")
        );

        Map<String, List<Person>> peopleByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        peopleByGender.forEach((gender, peopleList) -> {
            System.out.println(gender + ": ");
            peopleList.forEach(person -> System.out.println("  " + person));
        });

        Map<String, Map<String, List<Person>>> peopleByGenderAndAgeGroup = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        Collectors.groupingBy(person -> {
                            if (person.getAge() < 30) return "20s";
                            else if (person.getAge() < 40) return "30s";
                            else return "40s";
                        })
                ));

        peopleByGenderAndAgeGroup.forEach((gender, ageGroupMap) -> {
            System.out.println(gender + ": ");
            ageGroupMap.forEach((ageGroup, peopleList) -> {
                System.out.println("  " + ageGroup + ": ");
                peopleList.forEach(person -> System.out.println("    " + person));
            });
        });
    }
}
