package christmas.domain;

public class ChrismasEvent implements Event {
    private static final String NAME = "크리스마스 디데이 할인";
    private static final int START_DAY = 1;
    private static final int END_DAY = 25;
    private static final int BASE_DISCOUNT = 1000;
    private static final int DAILY_INCREMENT = 100;
    private static final int EVENT_MONTH = 12;

    @Override
    public boolean isValidDay(int month, int day) {
        if (EVENT_MONTH != month) {
            return false;
        }
        if (START_DAY <= day && day <= END_DAY) {
            return true;
        }
        return false;
    }

    @Override
    public int applyDiscount(final Orders orders, final int day, final int month) {
        if (!isValidDay(month, day)) {
            return 0;
        }
        return BASE_DISCOUNT + (day - START_DAY) * DAILY_INCREMENT;
    }

    @Override
    public String getName() {
        return NAME;
    }

}
