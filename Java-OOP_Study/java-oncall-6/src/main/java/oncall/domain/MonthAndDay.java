package oncall.domain;

public class MonthAndDay {

    private final Month month;
    private int date;
    private Day day;

    public MonthAndDay(final Month month, final Day day) {
        this.month = month;
        this.date = 1;
        this.day = day;
    }

    public void nextDate() {
        date++;
        day = Day.nextDay(day);
    }

    public boolean isHoliday() {
        return day.isWeekend() || LegalHoliday.isHoliday(month.getMonth(), date);
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
