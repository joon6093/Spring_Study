package chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorReducingAndReduce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. Collectors.reducing()를 사용한 합계 계산
        int sumWithCollectorsReducing = numbers.stream()
                .collect(Collectors.reducing(0, Integer::sum));
        System.out.println("Collectors.reducing()을 사용한 합계: " + sumWithCollectorsReducing);

        // 2. Stream.reduce()를 사용한 합계 계산
        Optional<Integer> sumWithReduce = numbers.stream()
                .reduce(Integer::sum);
        sumWithReduce.ifPresent(sum -> System.out.println("Stream.reduce()를 사용한 합계: " + sum));

        // 3. Collectors.reducing()를 사용한 더 복잡한 연산 (곱셈)
        int productWithCollectorsReducing = numbers.stream()
                .collect(Collectors.reducing(1, (a, b) -> a * b));
        System.out.println("Collectors.reducing()을 사용한 곱셈 결과: " + productWithCollectorsReducing);

        // 4. Stream.reduce()를 사용한 곱셈 연산
        Optional<Integer> productWithReduce = numbers.stream()
                .reduce((a, b) -> a * b);
        productWithReduce.ifPresent(product -> System.out.println("Stream.reduce()를 사용한 곱셈 결과: " + product));
    }
}
