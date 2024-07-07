package chapter5;

import java.util.Arrays;
import java.util.List;

public class FindFirstParallelExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        String result = list.parallelStream()
                .peek(System.out::println)
                .findFirst()
                .orElse("No value");

        System.out.println("Result: " + result);
    }
}
