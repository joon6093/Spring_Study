package oncall.view.output;

import java.util.List;
import oncall.domain.Roster;
import oncall.domain.Worker;
import oncall.domain.WorkingDay;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printRosters(final List<Roster> rosters) {
        rosters.forEach(roster -> {
            WorkingDay workingDay = roster.getWorkingDay();
            Worker worker = roster.getWorker();
            
            StringBuilder stringBuilder = getStringBuilder(workingDay, worker);

            System.out.println(stringBuilder);
        });
    }

    private static StringBuilder getStringBuilder(WorkingDay workingDay, Worker worker) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(workingDay.getMonth().getName()).append(" ").append(workingDay.getDate()).append("일 ")
                .append(workingDay.getDay().getName());
        if (workingDay.isWeekdayHoliday()) {
            stringBuilder.append("(휴일)");
        }
        stringBuilder.append(" ").append(worker.getName());
        return stringBuilder;
    }

    public void printErrorMessage(final String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
