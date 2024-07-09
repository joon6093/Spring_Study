package chapter5;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 10, 5, 6, 7);

        boolean anyGreaterThanNine = numbers.stream()
                .anyMatch(n -> n > 9);
        System.out.println("Any number greater than 9: " + anyGreaterThanNine);  // Output: true

        boolean allLessThanTen = numbers.stream()
                .allMatch(n -> n < 10);
        System.out.println("All numbers less than 10: " + allLessThanTen);  // Output: false

        boolean noneLessThanZero = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println("No number less than 0: " + noneLessThanZero);  // Output: true
    }
}
