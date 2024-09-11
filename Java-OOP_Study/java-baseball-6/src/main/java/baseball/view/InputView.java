package baseball.view;

import baseball.execption.ExceptionMessage;

public interface InputView {

    int getInputNumbers();

    default int validateInputIsInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_TYPE.getMessage());
        }
    }
}
