package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // 1. 컬렉션(Collection)에서 스트림 생성
        List<String> list = Arrays.asList("A", "B", "C", "D");
        Stream<String> collectionStream = list.stream();
        List<String> lowerCaseList = collectionStream
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println("컬렉션에서 생성된 스트림: " + lowerCaseList); // 출력: [a, b, c, d]

        // 2. 배열(Array)에서 스트림 생성
        String[] array = {"A", "B", "C", "D"};
        Stream<String> arrayStream = Arrays.stream(array);
        arrayStream.map(String::toLowerCase)
                .forEach(System.out::println); // 출력: a b c d

        // IntStream 예제
        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intArrayStream = Arrays.stream(intArray);
        int sum = intArrayStream.sum();
        System.out.println("배열에서 생성된 스트림의 합계: " + sum); // 출력: 합계: 15

        // 3. 스트림 빌더(Stream.builder()) 사용
        Stream<String> builderStream = Stream.<String>builder()
                .add("A")
                .add("B")
                .add("C")
                .build();
        builderStream.map(String::toLowerCase)
                .forEach(System.out::println); // 출력: a b c

        // 4. 특정 범위의 숫자 스트림 생성
        IntStream rangeStream = IntStream.range(1, 5);
        rangeStream.forEach(System.out::println); // 출력: 1 2 3 4

        // 5. 값이나 함수를 이용해 스트림 생성
        Stream<String> generateStream = Stream.generate(() -> "Echo").limit(5);
        generateStream.forEach(System.out::println); // 출력: Echo Echo Echo Echo Echo
    }
}
