package chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three");

        // 1. 정적 메서드 참조
        Consumer<String> printConsumer = System.out::println;  // x -> System.out.println(x);
        processList(list, printConsumer);

        // 2. 다양한 형식의 인스턴스 메서드 참조
        Function<String, Integer> parseIntFunction = Integer::parseInt;  // s -> Integer.parseInt(s);
        Integer number = parseIntFunction.apply("123");
        System.out.println("Parsed number: " + number);

        BiFunction<String, String, Boolean> startsWithFunction = String::startsWith; // (s, prefix) -> s.startsWith(prefix);
        Boolean result = startsWithFunction.apply("hello", "he");
        System.out.println("Does 'hello' start with 'he'? " + result);

        // 3. 기존 객체의 인스턴스 메서드 참조
        String targetString = "hello";
        Function<String, Boolean> instanceMethodReference = targetString::startsWith; //  prefix -> targetString.startsWith(prefix);
        System.out.println("Does 'hello' start with 'he' using instance method reference? " + instanceMethodReference.apply("he"));

        // 4. 생성자 참조
        Supplier<Car> carSupplier = Car::new;
        Car car = carSupplier.get();
        System.out.println("Car created: " + car);
    }

    // Consumer를 받아 리스트의 각 요소에 대해 작업을 수행하는 메서드
    public static void processList(List<String> list, Consumer<String> consumer) {
        for (String s : list) {
            consumer.accept(s);
        }
    }
}

// Car 클래스 정의
class Car {
    private String name;
    private int position;

    // 기본 생성자
    public Car() {
        this.name = "default";
        this.position = 0;
    }

    @Override
    public String toString() {
        return "Car{name='" + name + "', position=" + position + "}";
    }
}
