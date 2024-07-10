package chapter11;

import java.util.*;

public class OptionalStreamExample {
    public static void main(String[] args) {
        List<Optional<Integer>> optionalNumbers = List.of(
                Optional.of(10),
                Optional.empty(),
                Optional.of(20),
                Optional.empty(),
                Optional.of(30)
        );

        // Optional 값 중 존재하는 값만 합산
        int sum = optionalNumbers.stream()
                .flatMap(Optional::stream) // Optional을 0개 이상의 항목을 포함하는 스트림으로 변환
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum: " + sum); // 출력: Sum: 60
    }
}
