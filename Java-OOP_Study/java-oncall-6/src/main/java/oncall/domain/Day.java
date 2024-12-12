package oncall.domain;

import java.util.Arrays;
import java.util.List;
import oncall.error.ErrorType;

public enum Day {

    MONDAY("월", false),
    TUESDAY("화", false),
    WEDNESDAY("수", false),
    THURSDAY("목", false),
    FRIDAY("금", false),
    SATURDAY("토", true),
    SUNDAY("일", true);

    private final String name;
    private final boolean isWeekend;

    Day(final String name, final boolean isWeekend) {
        this.name = name;
        this.isWeekend = isWeekend;
    }

    public static Day findByDay(final String day) {
        return Arrays.stream(Day.values())
                .filter(temp -> temp.getName().equals(day))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorType.INVALID_INPUT.getMessage()));
    }

    public static Day nextDay(final Day day) {
        List<Day> list = Arrays.stream(Day.values())
                .toList();

        int index = list.indexOf(day) + 1;
        index = index % list.size();
        return list.get(index);
    }


    public String getName() {
        return name;
    }

    public boolean isWeekend() {
        return isWeekend;
    }
}
