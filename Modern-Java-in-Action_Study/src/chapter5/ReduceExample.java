package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // sum() 사용
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum()을 사용한 합계: " + sum);  // 출력: 합계: 15

        // reduce() 사용 - 합계
        int reduceSum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("reduce()를 사용한 합계: " + reduceSum);  // 출력: 합계: 15

        // max() 사용
        Optional<Integer> max = numbers.stream()
                .max(Integer::compare);
        max.ifPresent(value -> System.out.println("max()를 사용한 최대 값: " + value));  // 출력: 최대 값: 5

        // reduce() 사용 - 최대 값
        Optional<Integer> reduceMax = numbers.stream()
                .reduce(Integer::max);
        reduceMax.ifPresent(value -> System.out.println("reduce()를 사용한 최대 값: " + value));  // 출력: 최대 값: 5

        // reduce() 사용 - 곱셈
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("reduce()를 사용한 곱셈 결과: " + product);  // 출력: 곱셈 결과: 120

        // 문자열 리스트 연결 예제
        List<String> words = Arrays.asList("안녕", "세상", "자바", "스트림");
        String concatenatedString = words.stream()
                .reduce("", (a, b) -> a.isEmpty() ? b : a + "-" + b);
        System.out.println("reduce()를 사용한 문자열 연결: " + concatenatedString);  // 출력: 연결된 문자열: 안녕-세상-자바-스트림
    }
}
