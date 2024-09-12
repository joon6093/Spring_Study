package racingcar.controller;

import java.util.List;
import racingcar.dto.RaceDto;
import racingcar.model.Race;
import racingcar.view.ConsoleView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView consoleInputView;
    private final OutputView consoleOutputView;

    public RacingGameController(InputView consoleInputView, OutputView consoleOutputView) {
        this.consoleInputView = consoleInputView;
        this.consoleOutputView = consoleOutputView;
    }

    public void run() {
        List<String> carNames = consoleInputView.inputCarNames();
        int numberOfAttempts = consoleInputView.inputNumberOfAttempts();

        Race race = new Race(carNames);

        for (int i = 0; i < numberOfAttempts; i++) {
            race.moveCars();
            consoleOutputView.printRaceStatus(RaceDto.from(race));
        }

        List<String> winners = race.getWinners();
        consoleOutputView.printWinners(winners);
    }
}
