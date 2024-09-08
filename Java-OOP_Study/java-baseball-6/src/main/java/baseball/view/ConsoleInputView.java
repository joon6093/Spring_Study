package baseball.view;

import baseball.execption.ExceptionMessage;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView {

    public ConsoleInputView() {
    }

    public String getInputPlayerNumbers() {
        String input = Console.readLine();
        validateInputIsInteger(input);
        return input;
    }

    private void validateInputIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_TYPE.getMessage());
        }
    }
}
