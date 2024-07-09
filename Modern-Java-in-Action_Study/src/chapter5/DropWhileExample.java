package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DropWhileExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 10, 5, 6, 7);

        List<Integer> remainingNumbers = numbers.stream()
                .dropWhile(n -> n < 10)
                .collect(Collectors.toList());

        System.out.println(remainingNumbers);
    }
}
