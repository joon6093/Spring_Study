package oncall.domain;

public class Administrator {

    private final WeekdayList weekdayList;
    private int weekdayIndex;
    private Worker nextWeekdayWorker;
    private final WeekendList weekendList;
    private int weekendIndex;
    private Worker nextWeekendWorker;

    public Administrator(final WeekdayList weekdayList, final WeekendList weekendList) {
        this.weekdayList = weekdayList;
        this.weekdayIndex = 0;
        this.nextWeekdayWorker = null;
        this.weekendList = weekendList;
        this.weekendIndex = 0;
        this.nextWeekendWorker = null;
    }

    public Roster findNextDayWorker(final MonthAndDay monthAndDay, final Worker previousEmployee) {
        if (monthAndDay.isHoliday()) {
            return createRosterInHoliday(monthAndDay, previousEmployee);
        }

        return createRosterInWorkingDay(monthAndDay, previousEmployee);
    }

    private Roster createRosterInHoliday(final MonthAndDay monthAndDay, final Worker previousEmployee) {
        Worker worker = weekendList.getWorkers().get(weekendIndex);
        if (hasNextWeekendWorker()) {
            worker = nextWeekendWorker;
            nextWeekendWorker = null;
        }

        if (worker.equals(previousEmployee)) {
            nextWeekendWorker = worker;
            worker = weekendList.getWorkers()
                    .get(calculateIndex(weekendIndex + 1, weekendList.getWorkers().size()));
        }

        weekendIndex = calculateIndex(weekendIndex + 1, weekendList.getWorkers().size());
        WorkingDay workingDay = new WorkingDay(monthAndDay.getMonth(), monthAndDay.getDate(), monthAndDay.getDay());
        return new Roster(workingDay, worker);
    }

    private Roster createRosterInWorkingDay(final MonthAndDay monthAndDay, final Worker previousEmployee) {
        Worker worker = weekdayList.getWorkers().get(weekdayIndex);
        if (hasNextWeekdayWorker()) {
            worker = nextWeekdayWorker;
            nextWeekdayWorker = null;
        }

        if (worker.equals(previousEmployee)) {
            nextWeekdayWorker = worker;
            worker = weekdayList.getWorkers().get(calculateIndex(weekdayIndex + 1, weekdayList.getWorkers().size()));
        }

        weekdayIndex = calculateIndex(weekdayIndex + 1, weekdayList.getWorkers().size());
        WorkingDay workingDay = new WorkingDay(monthAndDay.getMonth(), monthAndDay.getDate(), monthAndDay.getDay());
        return new Roster(workingDay, worker);
    }

    public int calculateIndex(int index, final int size) {
        return index % size;
    }

    private boolean hasNextWeekendWorker() {
        return nextWeekendWorker != null;
    }

    private boolean hasNextWeekdayWorker() {
        return nextWeekdayWorker != null;
    }
}
