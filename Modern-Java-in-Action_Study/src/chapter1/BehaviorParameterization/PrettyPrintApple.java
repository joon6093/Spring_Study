package chapter1.BehaviorParameterization;

import java.util.List;

public class PrettyPrintApple {
    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = List.of(
                new Apple("green", 150),
                new Apple("red", 200),
                new Apple("yellow", 100)
        );

        prettyPrintApple(inventory, new AppleSimpleFormatter());

        prettyPrintApple(inventory, new AppleFancyFormatter());
    }
}
