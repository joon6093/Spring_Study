package chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class VoidCompatibilityExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");

        // void를 반환하는 람다 표현식
        Consumer<String> printConsumer = s -> System.out.println(s);
        processList(list, printConsumer);

        // boolean을 반환하는 람다 표현식
        List<String> newList = new ArrayList<>(list);  // 새로운 리스트를 생성하여 원본 리스트 보호
        Consumer<String> addConsumer = s -> newList.add(s + " new");
        processList(list, addConsumer);  // 원본 리스트를 전달하여 새 리스트에 요소를 추가

        // 원본 리스트와 새 리스트의 상태 출력
        System.out.println("Original list: " + list);
        System.out.println("New list: " + newList);
    }

    // Consumer를 받아 리스트의 각 요소에 대해 작업을 수행하는 메서드
    public static void processList(List<String> list, Consumer<String> consumer) {
        for (String s : list) {
            consumer.accept(s);
        }
    }
}
