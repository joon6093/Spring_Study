package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public int getInputNumbers() {
        String input = Console.readLine();
        return validateInputIsInteger(input);
    }
}
