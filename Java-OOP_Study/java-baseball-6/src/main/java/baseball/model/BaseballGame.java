package baseball.model;

import baseball.dto.PlayerScoreDto;
import java.util.List;

public class BaseballGame {
    private final Player firstPlayer;
    private final Player secondPlayer;

    public BaseballGame(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public PlayerScoreDto playGame() {
        List<Integer> firstPlayerNumbers = firstPlayer.getChosenNumbers();
        List<Integer> secondPlayerNumbers = secondPlayer.getChosenNumbers();

        int strikeCount = calculateStrikes(firstPlayerNumbers, secondPlayerNumbers);
        int ballCount = calculateBalls(firstPlayerNumbers, secondPlayerNumbers);

        return new PlayerScoreDto(strikeCount, ballCount);
    }

    private int calculateStrikes(List<Integer> firstPlayerNumbers, List<Integer> secondPlayerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < BaseballGameValue.NUMBER_SIZE.getValue(); i++) {
            if (secondPlayerNumbers.get(i).equals(firstPlayerNumbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int calculateBalls(List<Integer> firstPlayerNumbers, List<Integer> secondPlayerNumbers) {
        int ballCount = 0;
        for (int i = 0; i < BaseballGameValue.NUMBER_SIZE.getValue(); i++) {
            if (!secondPlayerNumbers.get(i).equals(firstPlayerNumbers.get(i))
                    && firstPlayerNumbers.contains(secondPlayerNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
