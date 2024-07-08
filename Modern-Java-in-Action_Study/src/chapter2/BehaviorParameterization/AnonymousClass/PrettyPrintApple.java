package chapter2.BehaviorParameterization.AnonymousClass;

import chapter2.BehaviorParameterization.Apple;
import chapter2.BehaviorParameterization.AppleFormatter;

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

        prettyPrintApple(inventory, new AppleFormatter() {
            @Override
            public String accept(Apple apple) {
                return "An apple of " + apple.getWeight() + "g";
            }
        });

        prettyPrintApple(inventory, new AppleFormatter() {
            @Override
            public String accept(Apple apple) {
                String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
                return "A " + characteristic + " " + apple.getColor() + " apple";
            }
        });
    }
}
