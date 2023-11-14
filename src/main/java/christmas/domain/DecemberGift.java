package christmas.domain;

import christmas.common.consts.SystemConst;
import java.time.LocalDate;

public class DecemberGift implements Gift {
    private static final String NAME = "증정 이벤트";
    private static final LocalDate START_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.START_DAY);
    private static final LocalDate END_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.DECEMBER_END_DAY);

    @Override
    public boolean isValidDay(LocalDate localDate) {
        if (localDate.isAfter(START_DAY) && localDate.isBefore(END_DAY)) {
            return true;
        }
        return false;
    }

    @Override
    public Menu getGift(Orders orders, LocalDate localDate) {
        if (!isValidDay(localDate)) {
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
