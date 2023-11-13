package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.consts.ErrorMessage;

public class InputView {
    public static int nextInt() {
        try {
            int n = Integer.parseInt(Console.readLine());
            return n;
        } catch (NumberFormatException e) {
            OutputView.printErr(ErrorMessage.INVALID_DAY_INPUT_ERROR.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.INVALID_DAY_INPUT_ERROR.getErrorMessage());
        }
    }


}
