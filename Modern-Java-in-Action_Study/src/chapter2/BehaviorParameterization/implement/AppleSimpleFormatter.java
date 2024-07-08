package chapter2.BehaviorParameterization.implement;

import chapter2.BehaviorParameterization.Apple;
import chapter2.BehaviorParameterization.AppleFormatter;

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
