package baseball.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HumanPlayer implements Player {
    private final PlayerNumbers playerNumbers;

    public HumanPlayer(PlayerNumbers playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public static HumanPlayer fromInput(String input) {
        List<Integer> numbers = IntStream.range(0, input.length())
                .mapToObj(i -> Character.getNumericValue(input.charAt(i)))
                .collect(Collectors.toList());
        return new HumanPlayer(new PlayerNumbers(numbers));
    }

    @Override
    public List<Integer> getChosenNumbers() {
        return playerNumbers.getNumbers();
    }
}
