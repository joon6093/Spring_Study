package chapter1.BehaviorParameterization.implement;

import chapter1.BehaviorParameterization.Apple;
import chapter1.BehaviorParameterization.AppleFormatter;

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
