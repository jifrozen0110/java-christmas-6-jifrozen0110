package christmas.domain;

import christmas.common.consts.SystemConst;
import java.time.LocalDate;

public class DecemberGift implements Gift {
    public static final int EVENT_EXECUTION_MONEY = 120_000;
    private static final String NAME = "증정 이벤트";
    private static final LocalDate START_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.START_DAY);
    private static final LocalDate END_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.DECEMBER_END_DAY);

    @Override
    public boolean validatePrice(final Orders orders) {
        return orders.getTotalPrice() >= EVENT_EXECUTION_MONEY;
    }

    @Override
    public boolean isValidDay(final LocalDate localDate) {
        return !localDate.isBefore(START_DAY) && !localDate.isAfter(END_DAY);
    }

    @Override
    public Menu getGift(final Orders orders, final LocalDate localDate) {
        if (!isValidDay(localDate) || !validatePrice(orders)) {
            return null;
        }
        return Menu.CHAMPAGNE;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
