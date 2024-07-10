package chapter11;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // 정상적인 값이 있는 경우
        Optional<String> nonEmptyOptional = Optional.of("Hello, World!");

        String result1 = nonEmptyOptional
                .flatMap(value -> Optional.of(value + " from flatMap"))
                .map(value -> value + " and map")
                .orElse("Default Value");

        System.out.println("Result when value is present: " + result1);

        // 값이 없는 경우 (Optional.empty())
        Optional<String> emptyOptional = Optional.empty();

        String result2 = emptyOptional
                .flatMap(value -> Optional.of(value + " from flatMap"))
                .map(value -> value + " and map")
                .orElse("Default Value");

        System.out.println("Result when value is empty: " + result2);

        // 값이 중간에 없는 경우
        String result3 = nonEmptyOptional
                .flatMap(value -> Optional.empty())
                .map(value -> value + " and map")
                .orElse("Default Value");

        System.out.println("Result when value is empty: " + result3);
    }
}
