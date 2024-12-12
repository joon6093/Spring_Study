package oncall.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import oncall.domain.Day;
import oncall.domain.Month;
import oncall.domain.MonthAndDay;
import oncall.error.ErrorType;

public class InputView {

    private final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

    public MonthAndDay readMonthAndDay() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        final String input = getConsoleInput();
        String[] strings = getStrings(input);
        Month month = Month.findByMonth(Integer.parseInt(strings[0]));
        Day day = Day.findByDay(strings[1]);

        return new MonthAndDay(month, day);
    }

    private String[] getStrings(String input) {
        String[] strings = splitItems(input);
        validateSize(strings);
        validateNumber(strings[0]);
        return strings;
    }

    public List<String> readWeekdayList() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        final String input = getConsoleInput();
        String[] strings = splitItems(input);
        return Arrays.stream(strings).toList();
    }

    public List<String> readWeekendList() {
        System.out.print("휴일  비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        final String input = getConsoleInput();
        String[] strings = splitItems(input);
        return Arrays.stream(strings).toList();
    }

    private String getConsoleInput() {
        String input = Console.readLine();
        validateNotNull(input);
        return input.trim();
    }

    private void validateNotNull(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT.getMessage());
        }
    }

    private void validateNumber(final String input) {
        validateIsNumeric(input);
        validateRange(input);
    }

    private void validateIsNumeric(final String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT.getMessage());
        }
    }

    private void validateRange(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT.getMessage());
        }
    }

    private void validateSize(final String[] inputs) {
        if (inputs.length != 2) {
            throw new IllegalArgumentException(ErrorType.INVALID_INPUT.getMessage());
        }
    }

    private String[] splitItems(final String input) {
        return Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
