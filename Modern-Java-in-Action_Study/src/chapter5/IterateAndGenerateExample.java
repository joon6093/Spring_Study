package chapter5;

import java.util.Random;
import java.util.stream.Stream;

public class IterateAndGenerateExample {
    public static void main(String[] args) {
        // 1. Stream.iterate 예제: 1부터 시작하여 각 요소를 2씩 증가시키는 스트림
        System.out.println("Stream.iterate 예제:");
        Stream<Integer> iterateStream = Stream.iterate(1, n -> n + 2);
        iterateStream.limit(10).forEach(System.out::println); // 출력: 1 3 5 7 9 11 13 15 17 19

        // 2. Stream.generate 예제: "Echo" 문자열을 반복 생성하는 스트림
        System.out.println("\nStream.generate 예제:");
        Stream<String> generateStream = Stream.generate(() -> "Echo");
        generateStream.limit(5).forEach(System.out::println); // 출력: Echo Echo Echo Echo Echo

        // 3. Stream.iterate를 사용한 피보나치 수열 생성
        System.out.println("\nStream.iterate를 사용한 피보나치 수열 생성:");
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(n -> n[0])
                .forEach(System.out::println); // 출력: 0 1 1 2 3 5 8 13 21 34

        // 4. Stream.generate를 사용한 난수 생성
        System.out.println("\nStream.generate를 사용한 난수 생성:");
        Stream<Double> randomStream = Stream.generate(Math::random);
        randomStream.limit(5).forEach(System.out::println);

        // 5. Stream.generate를 사용하여 Random 객체를 통해 난수 생성
        System.out.println("\nRandom 객체를 사용한 난수 생성:");
        Random random = new Random();
        Stream<Integer> randomIntStream = Stream.generate(() -> random.nextInt(100));
        randomIntStream.limit(5).forEach(System.out::println);
    }
}
