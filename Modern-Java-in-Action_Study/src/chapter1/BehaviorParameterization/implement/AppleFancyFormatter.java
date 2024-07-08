package chapter1.BehaviorParameterization.implement;

import chapter1.BehaviorParameterization.Apple;
import chapter1.BehaviorParameterization.AppleFormatter;

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}
