package oncall.domain;

public class WorkingDay {

    private final Month month;
    private final int date;
    private final Day day;

    public WorkingDay(final Month month, final int date, final Day day) {
        this.month = month;
        this.date = date;
        this.day = day;
    }

    public boolean isWeekdayHoliday() {
        return !day.isWeekend() && LegalHoliday.isHoliday(month.getMonth(), date);
    }

    public Month getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public Day getDay() {
        return day;
    }
}
