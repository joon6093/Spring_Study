package oncall.domain;

import java.util.Arrays;

public enum LegalHoliday {

    THEOCRACY("신정", 1, 1),
    MARCH_1ST("신정", 3, 1),
    CHILDREN_S_DAY("신정", 5, 5),
    MEMORIAL_DAY("신정", 6, 6),
    LIBERATION_DAY("신정", 8, 15),
    NATIONAL_FOUNDATION_DAY("신정", 10, 3),
    HANGUL_DAY("신정", 10, 9),
    CHRISTMAS("신정", 12, 25);

    private final String name;
    private final int month;
    private final int day;

    LegalHoliday(final String name, final int month, final int day) {
        this.name = name;
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(final int month, final int day) {
        return Arrays.stream(LegalHoliday.values())
                .anyMatch(legalHoliday -> legalHoliday.getMonth() == month && legalHoliday.getDay() == day);
    }

    public String getName() {
        return name;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
