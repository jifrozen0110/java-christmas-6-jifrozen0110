package christmas.domain;

import christmas.common.consts.SystemConst;
import java.time.LocalDate;

public class ChristmasEvent implements Event {
    private static final String NAME = "크리스마스 디데이 할인";
    private static final LocalDate START_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.START_DAY);
    private static final LocalDate END_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.CHRISTMAS_DAY);
    public static final int EVENT_EXECUTION_MONEY = 10_000;
    private static final int BASE_DISCOUNT = 1_000;
    private static final int DAILY_INCREMENT = 100;

    @Override
    public boolean validatePrice(Orders orders) {
        return orders.getTotalPrice() >= EVENT_EXECUTION_MONEY;
    }

    @Override
    public boolean isValidDay(final LocalDate localDate) {
        return !localDate.isBefore(START_DAY) && !localDate.isAfter(END_DAY);
    }

    @Override
    public int applyDiscount(final Orders orders, final LocalDate localDate) {
        if (!isValidDay(localDate) || !validatePrice(orders)) {
            return 0;
        }
        return BASE_DISCOUNT + (localDate.compareTo(START_DAY)) * DAILY_INCREMENT;
    }

    @Override
    public String getName() {
        return NAME;
    }

}
