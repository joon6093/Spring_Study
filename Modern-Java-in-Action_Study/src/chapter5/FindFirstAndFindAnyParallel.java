package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstAndFindAnyParallel {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        long startTime = System.nanoTime();
        Optional<String> firstElement = list.parallelStream().findFirst();
        long endTime = System.nanoTime();
        System.out.println("findFirst (parallel): " + firstElement.orElse("No value") + ", Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        Optional<String> anyElement = list.parallelStream().findAny();
        endTime = System.nanoTime();
        System.out.println("findAny (parallel): " + anyElement.orElse("No value") + ", Time: " + (endTime - startTime) + " ns");
    }
}
