package oncall.domain;

import java.util.List;
import oncall.error.ErrorType;

public class WeekendList {

    private final List<Worker> workers;

    public WeekendList(final List<Worker> workers) {
        validateListSizeRange(workers);
        validateUnique(workers);
        this.workers = workers;
    }

    private void validateListSizeRange(final List<Worker> inputs) {
        if (inputs.size() < 5 || inputs.size() > 35) {
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT.getMessage());
        }
    }

    private void validateUnique(final List<Worker> inputs) {
        if (inputs.stream().distinct().count() != inputs.size()) {
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT.getMessage());
        }
    }

    public List<Worker> getWorkers() {
        return workers;
    }
}
