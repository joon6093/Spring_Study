package oncall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import oncall.domain.Administrator;
import oncall.domain.MonthAndDay;
import oncall.domain.Roster;
import oncall.domain.WeekdayList;
import oncall.domain.WeekendList;
import oncall.domain.Worker;
import oncall.view.input.InputView;
import oncall.view.output.OutputView;

public class OncallController {

    private final InputView inputView;
    private final OutputView outputView;

    public OncallController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final MonthAndDay monthAndDay = getMonthAndDay();
        final Administrator administrator = getAdministrator();
        final List<Roster> rosters = getRosters(monthAndDay, administrator);

        outputView.printRosters(rosters);
    }

    private MonthAndDay getMonthAndDay() {
        return executeWithRetry(inputView::readMonthAndDay);
    }

    private Administrator getAdministrator() {
        return executeWithRetry(() -> {
            WeekdayList weekdayList = new WeekdayList(inputView.readWeekdayList().stream()
                    .map(Worker::new)
                    .toList());
            WeekendList weekendList = new WeekendList(inputView.readWeekendList().stream()
                    .map(Worker::new)
                    .toList());
            return new Administrator(weekdayList, weekendList);
        });
    }

    private List<Roster> getRosters(MonthAndDay monthAndDay, Administrator administrator) {
        final List<Roster> rosters = new ArrayList<>();
        for (int i = 0; i < monthAndDay.getMonth().getMaxDay(); i++) {
            Worker previousEmployee = null;
            if (i != 0) {
                previousEmployee = rosters.getLast().getWorker();
            }
            Roster roster = administrator.findNextDayWorker(monthAndDay, previousEmployee);
            rosters.add(roster);
            monthAndDay.nextDate();
        }
        return rosters;
    }

    private <T> T executeWithRetry(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
