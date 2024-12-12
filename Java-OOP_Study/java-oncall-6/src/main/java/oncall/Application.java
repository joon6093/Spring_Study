package oncall;

import oncall.controller.OncallController;
import oncall.view.input.InputView;
import oncall.view.output.OutputView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();

        final OncallController oncallController = new OncallController(inputView, outputView);
        oncallController.run();
    }
}
