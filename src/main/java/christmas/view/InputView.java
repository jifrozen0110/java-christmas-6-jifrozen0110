package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.common.consts.ErrorMessage;
import christmas.common.validator.DateValidator;

public class InputView {

    public static final String REGEX = ",";

    public static String next() {
        return Console.readLine();
    }

    public static int nextInt() {
        try {
            int n = Integer.parseInt(next());
            return n;
        } catch (NumberFormatException e) {
            OutputView.printErr(ErrorMessage.INVALID_DAY_INPUT_ERROR.getErrorMessage());
            return nextInt();
        }
    }

    public static String[] nextArrString() {
        String str = next();
        return str.split(REGEX);
    }

    public static int nextDay(final int month) {
        int n = nextInt();
        try {
            DateValidator.validate(month, n);
        } catch (IllegalArgumentException e) {
            return nextDay(month);
        }
        return n;
    }


}
