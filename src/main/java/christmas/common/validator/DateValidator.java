package christmas.common.validator;

import christmas.common.consts.ErrorMessage;

public class DateValidator {

    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MIN_DAY = 1;
    private static final int MAX_DAY_30 = 30;
    private static final int MAX_DAY_28 = 28;
    private static final int MAX_DAY_31 = 31;

    private static final int APRIL = 4;
    private static final int JUNE = 6;
    private static final int SEPTEMBER = 9;
    private static final int NOVEMBER = 11;
    private static final int FEBRUARY = 2;

    public static void validate(int month, int day) {
        if (month < MIN_MONTH || month > MAX_MONTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DAY_INPUT_ERROR.getErrorMessage());
        }

        int maxDay = getMaxDay(month);
        if (day < MIN_DAY || day > maxDay) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DAY_INPUT_ERROR.getErrorMessage());
        }
    }

    private static int getMaxDay(int month) {
        switch (month) {
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return MAX_DAY_30;
            case FEBRUARY:
                return MAX_DAY_28;
            default:
                return MAX_DAY_31;
        }
    }
}
