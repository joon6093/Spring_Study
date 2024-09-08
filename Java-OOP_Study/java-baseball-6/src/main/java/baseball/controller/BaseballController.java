package baseball.controller;

import baseball.dto.PlayerScoreDto;
import baseball.execption.ExceptionMessage;
import baseball.model.BaseballGame;
import baseball.model.BaseballGameValue;
import baseball.model.ComputerPlayer;
import baseball.model.HumanPlayer;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleOutputView;

public class BaseballController {
    private static final String RESTART = "1";
    private static final String END = "2";

    private final ConsoleInputView inputView = new ConsoleInputView();
    private final ConsoleOutputView outputView = new ConsoleOutputView();

    public void runBaseballGame() {
        boolean playAgain;
        do {
            outputView.displayStartMessage();
            runSingleGame();
            playAgain = askForReplay();
        } while (playAgain);
    }

    private void runSingleGame() {
        ComputerPlayer computerPlayer = new ComputerPlayer();
        boolean gameComplete = false;

        while (!gameComplete) {
            outputView.displayInputPrompt();
            String input = inputView.getInputPlayerNumbers();
            HumanPlayer humanPlayer = HumanPlayer.fromInput(input);

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
        String input = inputView.getInputPlayerNumbers();

        if (input.equals(RESTART)) {
            return true;
        } else if (input.equals(END)) {
            return false;
        } else {
            throw new IllegalArgumentException(ExceptionMessage.RESTART_COMMAND.getMessage());
        }
    }
}
