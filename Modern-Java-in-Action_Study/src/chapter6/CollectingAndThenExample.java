package chapter6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectingAndThenExample {
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

        List<Person> immutablePeopleList = people.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));

        // 불변 리스트 출력
        immutablePeopleList.forEach(System.out::println);

        // immutablePeopleList.add(new Person("Hank", 45, "Male"));   // UnsupportedOperationException을 발생


        Map<String, List<Person>> groupedByGender = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                Collections::unmodifiableList
                        )
                ));

        groupedByGender.forEach((gender, immutableList) -> {
            System.out.println(gender + ":");
            immutableList.forEach(person -> System.out.println("  " + person));
        });

        // groupedByGender.get("Female").add(new Person("Hank", 45, "Male"));   // UnsupportedOperationException을 발생
    }
}
