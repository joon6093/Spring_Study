package baseball.model;

import baseball.execption.ExceptionMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNumbers {
    private final List<Integer> numbers;

    public PlayerNumbers(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberRange(numbers);
        validateNumberDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != BaseballGameValue.NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_SIZE.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.stream()
                .filter(n -> n < BaseballGameValue.MIN_RANGE.getValue() || n > BaseballGameValue.MAX_RANGE.getValue())
                .findAny()
                .ifPresent(n -> {
                    throw new IllegalArgumentException(ExceptionMessage.NUMBER_TYPE.getMessage());
                });
    }

    private void validateNumberDuplicates(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
