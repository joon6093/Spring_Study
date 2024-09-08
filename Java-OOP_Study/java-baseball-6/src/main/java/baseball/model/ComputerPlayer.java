package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer implements Player {
    private final PlayerNumbers playerNumbers;

    public ComputerPlayer() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < BaseballGameValue.NUMBER_SIZE.getValue()) {
            addUniqueRandomNumber(computerNumbers);
        }
        this.playerNumbers = new PlayerNumbers(computerNumbers);
    }

    private void addUniqueRandomNumber(List<Integer> numbers) {
        int number = Randoms.pickNumberInRange(BaseballGameValue.MIN_RANGE.getValue(),
                BaseballGameValue.MAX_RANGE.getValue());
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    @Override
    public List<Integer> getChosenNumbers() {
        return playerNumbers.getNumbers();
    }
}
