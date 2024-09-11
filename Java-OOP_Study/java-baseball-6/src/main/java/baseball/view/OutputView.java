package baseball.view;

import baseball.dto.PlayerScoreDto;

public interface OutputView {
    void displayGameResult(PlayerScoreDto playerScoreDto);

    void displayStartMessage();

    void displayInputPrompt();

    void displaySuccessMessage();

    void displayRetryPrompt();
}
