package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        RacingGameController racingGameController = new RacingGameController(consoleView, consoleView);
        racingGameController.run();
    }
}
