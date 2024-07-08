package chapter3;

import java.util.function.Function;

public class FunctionCompositionExample {
    public static void main(String[] args) {
        // 숫자를 1 증가시키는 함수
        Function<Integer, Integer> increment = x -> x + 1;

        // 숫자를 2배로 만드는 함수
        Function<Integer, Integer> multiply = x -> x * 2;

        // 함수 조합: 먼저 숫자를 1 증가시키고, 그 다음 2배로 만듦
        Function<Integer, Integer> incrementAndMultiply = increment.andThen(multiply);

        // 조합된 함수 적용
        Integer result = incrementAndMultiply.apply(5);
        System.out.println("숫자를 1 증가시키고 2배로 만든 결과: " + result);
    }
}
