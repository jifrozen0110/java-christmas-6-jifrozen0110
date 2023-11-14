package christmas.domain;

import christmas.common.consts.SystemConst;
import java.time.LocalDate;

public class DecemberGift implements Gift {
    public static final int EVENT_EXECUTION_MONEY = 10_000;
    private static final String NAME = "증정 이벤트";
    private static final LocalDate START_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.START_DAY);
    private static final LocalDate END_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.DECEMBER_END_DAY);

    @Override
    public boolean validatePrice(Orders orders) {
        return orders.getTotalPrice() >= EVENT_EXECUTION_MONEY;
    }

    @Override
    public boolean isValidDay(final LocalDate localDate) {
        return !localDate.isBefore(START_DAY) && !localDate.isAfter(END_DAY);
    }

    @Override
    public Menu getGift(Orders orders, LocalDate localDate) {
        if (!isValidDay(localDate) || !validatePrice(orders)) {
            return null;
        }
        if (orders.getTotalPrice() >= 120_000) {
            return Menu.CHAMPAGNE;
        }
        return null;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
