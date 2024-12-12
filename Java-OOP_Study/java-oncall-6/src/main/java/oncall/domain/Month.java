package oncall.domain;

import java.util.Arrays;
import oncall.error.ErrorType;

public enum Month {

    JANUARY("1월", 1, 31),
    FEBRUARY("2월", 2, 28),
    MARCH("3월", 3, 31),
    APRIL("4월", 4, 30),
    MAY("5월", 5, 31),
    JUNE("6월", 6, 30),
    JULY("7월", 7, 31),
    AUGUST("8월", 8, 31),
    SEPTEMBER("9월", 9, 30),
    OCTOBER("10월", 10, 31),
    NOVEMBER("11월", 11, 30),
    DECEMBER("12월", 12, 31);

    private final String name;
    private final int month;
    private final int maxDay;

    Month(final String name, final int month, final int maxDay) {
        this.name = name;
        this.month = month;
        this.maxDay = maxDay;
    }

    public static Month findByMonth(final int month) {
        return Arrays.stream(Month.values())
                .filter(temp -> temp.getMonth() == month)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorType.INVALID_INPUT.getMessage()));
    }

    public String getName() {
        return name;
    }

    public int getMonth() {
        return month;
    }

    public int getMaxDay() {
        return maxDay;
    }
}
