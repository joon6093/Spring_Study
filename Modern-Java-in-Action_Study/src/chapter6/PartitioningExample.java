package chapter6;

import java.util.*;
import java.util.stream.Collectors;

public class PartitioningExample {
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

        Map<Boolean, List<Person>> partitionedByAge = people.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() >= 30));

        partitionedByAge.forEach((isThirtyOrOlder, peopleList) -> {
            System.out.println(isThirtyOrOlder ? "30 and older:" : "Under 30:");
            peopleList.forEach(person -> System.out.println("  " + person));
        });

        Map<Boolean, Map<Boolean, List<Person>>> multiLevelPartitioned = people.stream()
                .collect(Collectors.partitioningBy(
                        person -> person.getAge() >= 30,
                        Collectors.partitioningBy(person -> "Male".equals(person.getGender()))
                ));

        multiLevelPartitioned.forEach((isThirtyOrOlder, genderMap) -> {
            System.out.println(isThirtyOrOlder ? "30 and older:" : "Under 30:");
            genderMap.forEach((isMale, peopleList) -> {
                System.out.println("  " + (isMale ? "Male:" : "Female:"));
                peopleList.forEach(person -> System.out.println("    " + person));
            });
        });
    }
}
