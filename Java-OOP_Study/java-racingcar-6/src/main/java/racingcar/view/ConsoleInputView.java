package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class ConsoleInputView implements InputView {
    @Override
    public List<String> inputCarNames() {
        String input = Console.readLine();
        try {
            return Arrays.asList(input.split(","));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public int inputNumberOfAttempts() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
