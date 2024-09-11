package baseball.view;

import baseball.model.BaseballGameValue;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomInputView implements InputView {

    @Override
    public int getInputNumbers() {
        StringBuilder randomInput = new StringBuilder();
        while (randomInput.length() < BaseballGameValue.NUMBER_SIZE.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(BaseballGameValue.MIN_RANGE.getValue(),
                    BaseballGameValue.MAX_RANGE.getValue());
            if (!randomInput.toString().contains(String.valueOf(randomNumber))) {
                randomInput.append(randomNumber);
            }
        }
        return validateInputIsInteger(randomInput.toString());
    }
}
