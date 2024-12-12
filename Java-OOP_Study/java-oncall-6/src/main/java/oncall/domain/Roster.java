package oncall.domain;

public class Roster {

    private final WorkingDay workingDay;
    private final Worker worker;

    public Roster(final WorkingDay workingDay, final Worker worker) {
        this.workingDay = workingDay;
        this.worker = worker;
    }

    public WorkingDay getWorkingDay() {
        return workingDay;
    }

    public Worker getWorker() {
        return worker;
    }
}
