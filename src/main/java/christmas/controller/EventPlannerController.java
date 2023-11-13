package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {
    public static void start() {
        OutputView.printGreetingsMessage();
        OutputView.printInputDayMessage();
        int day = InputView.nextInt();

    }
}
