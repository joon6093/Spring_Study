package chapter8;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Map.Entry;

public class CollectionFactoryMethodsExample {
    public static void main(String[] args) {
        // List.of() 예제
        List<String> fruits = List.of("Apple", "Banana", "Cherry");
        System.out.println("Fruits:");
        fruits.forEach(System.out::println);
        // fruits.add("Date"); // UnsupportedOperationException

        // Set.of() 예제
        Set<String> colors = Set.of("Red", "Green", "Blue");
        System.out.println("\nColors:");
        colors.forEach(System.out::println);
        // colors.add("Yellow"); // UnsupportedOperationException

        // Map.of() 예제
        Map<String, Integer> ageMap = Map.of("Alice", 30, "Bob", 25, "Charlie", 35);
        System.out.println("\nAge Map:");
        ageMap.forEach((name, age) -> System.out.println(name + " -> " + age));
        // ageMap.put("David", 40); // UnsupportedOperationException

        // Map.ofEntries() 예제
        Map<String, Integer> ageMapEntries = Map.ofEntries(
                Map.entry("Alice", 30),
                Map.entry("Bob", 25),
                Map.entry("Charlie", 35),
                Map.entry("David", 40)
        );
        System.out.println("\nAge Map (using Map.ofEntries):");
        ageMapEntries.forEach((name, age) -> System.out.println(name + " -> " + age));
        // ageMapEntries.put("Eve", 45); // UnsupportedOperationException
    }
}
