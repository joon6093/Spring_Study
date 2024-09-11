package baseball.view;

import baseball.dto.PlayerScoreDto;

public class ConsoleOutputView implements OutputView {

    @Override
    public void displayGameResult(PlayerScoreDto playerScoreDto) {
        StringBuilder resultBuilder = new StringBuilder();
        int strikeCount = playerScoreDto.getStrikeScore();
        int ballCount = playerScoreDto.getBallScore();

        if (ballCount != 0) {
            resultBuilder.append(ballCount).append(GameMessage.INFO_BALL.getMessage()).append(" ");
        }
        if (strikeCount != 0) {
            resultBuilder.append(strikeCount).append(GameMessage.INFO_STRIKE.getMessage()).append(" ");
        }
        if (strikeCount == 0 && ballCount == 0) {
            resultBuilder.append(GameMessage.INFO_NOTHING.getMessage());
        }

        System.out.println(resultBuilder.toString().trim());
    }

    @Override
    public void displayStartMessage() {
        System.out.println(GameMessage.INFO_START_GAME.getMessage());
    }

    @Override
    public void displaySuccessMessage() {
        System.out.println(GameMessage.INFO_SUCCESS_GAME.getMessage());
    }

    @Override
    public void displayRetryPrompt() {
        System.out.println(GameMessage.PROMPT_RETRY_CONFIRM.getMessage());
    }

    @Override
    public void displayInputPrompt() {
        System.out.print(GameMessage.PROMPT_INPUT_NUMBER.getMessage());
    }
}
