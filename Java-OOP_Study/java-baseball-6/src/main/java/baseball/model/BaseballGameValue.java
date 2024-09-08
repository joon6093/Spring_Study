package baseball.model;

public enum BaseballGameValue {
    NUMBER_SIZE(3),
    MIN_RANGE(1),
    MAX_RANGE(9),
    THREE_STRIKE(3),
    ;

    private final int value;

    BaseballGameValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
