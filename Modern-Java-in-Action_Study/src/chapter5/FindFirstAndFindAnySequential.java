package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstAndFindAnySequential {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        long startTime = System.nanoTime();
        Optional<String> firstElement = list.stream().findFirst();
        long endTime = System.nanoTime();
        System.out.println("findFirst (sequential): " + firstElement.orElse("No value") + ", Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        Optional<String> anyElement = list.stream().findAny();
        endTime = System.nanoTime();
        System.out.println("findAny (sequential): " + anyElement.orElse("No value") + ", Time: " + (endTime - startTime) + " ns");
    }
}
