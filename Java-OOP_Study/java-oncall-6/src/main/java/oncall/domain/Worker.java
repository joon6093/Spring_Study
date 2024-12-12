package oncall.domain;

import java.util.Objects;
import oncall.error.ErrorType;

public class Worker {

    private final String name;

    public Worker(final String name) {
        validateNotNull(name);
        validateSize(name);
        this.name = name;
    }

    private void validateNotNull(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT.getMessage());
        }
    }

    private void validateSize(final String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Worker worker = (Worker) o;
        return Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
