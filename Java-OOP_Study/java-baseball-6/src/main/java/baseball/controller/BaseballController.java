package baseball.controller;

import baseball.dto.PlayerScoreDto;
import baseball.execption.ExceptionMessage;
import baseball.model.BaseballGame;
import baseball.model.BaseballGameValue;
import baseball.model.Player;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleOutputView;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.RandomInputView;

public class BaseballController {
    private final InputView randomInputView = new RandomInputView();
    private final InputView consoleInputView = new ConsoleInputView();
    private final OutputView outputView = new ConsoleOutputView();

    public void runBaseballGame() {
        boolean playAgain;
        do {
            outputView.displayStartMessage();
            runSingleGame();
            playAgain = askForReplay();
        } while (playAgain);
    }

    private void runSingleGame() {
        Player computerPlayer = new Player(randomInputView.getInputNumbers());

        boolean gameComplete = false;

        while (!gameComplete) {
            Player humanPlayer = new Player(consoleInputView.getInputNumbers());

            BaseballGame game = new BaseballGame(computerPlayer, humanPlayer);
            PlayerScoreDto result = game.playGame();

            outputView.displayGameResult(result);

            if (result.getStrikeScore() == BaseballGameValue.THREE_STRIKE.getValue()) {
                outputView.displaySuccessMessage();
                gameComplete = true;
            }
        }
    }

    private boolean askForReplay() {
        outputView.displayRetryPrompt();
        int input = consoleInputView.getInputNumbers();

        if (input == 1) {
            return true;
        } else if (input == 2) {
            return false;
        } else {
            throw new IllegalArgumentException(ExceptionMessage.RESTART_COMMAND.getMessage());
        }
    }
}
