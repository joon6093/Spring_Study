package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomCollectExample {
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

        List<String> collect = people.stream() // 적절함
                .map(Person::getName)
                .collect(ArrayList::new, List::add, List::addAll);

        // 결과 출력
        collect.forEach(System.out::println);

        List<String> reduce = people.stream()  // 적절하지 않음
                .map(Person::getName)
                .reduce(new ArrayList<>(),
                        (list, name) -> {
                            list.add(name);
                            return list;
                        },
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        });

        // 결과 출력
        reduce.forEach(System.out::println);
    }
}
