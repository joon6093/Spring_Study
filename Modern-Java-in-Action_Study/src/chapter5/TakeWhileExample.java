package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TakeWhileExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 10, 5, 6, 7);

        List<Integer> filteredNumbers = numbers.stream()
                .takeWhile(n -> n < 10)
                .collect(Collectors.toList());

        System.out.println(filteredNumbers);
    }
}
