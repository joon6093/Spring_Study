package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final PlayerNumbers playerNumbers;

    public Player(int input) {
        this.playerNumbers = new PlayerNumbers(splitToDigits(input));
    }

    private List<Integer> splitToDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(0, number % 10);
            number /= 10;
        }
        return digits;
    }

    public List<Integer> getChosenNumbers() {
        return playerNumbers.getNumbers();
    }
}
