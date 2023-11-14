package christmas.domain;

import christmas.common.consts.SystemConst;
import java.time.LocalDate;

public class ChristmasEvent implements Event {
    private static final String NAME = "크리스마스 디데이 할인";
    private static final LocalDate START_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.START_DAY);
    private static final LocalDate END_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.CHRISTMAS_DAY);
    private static final int BASE_DISCOUNT = 1000;
    private static final int DAILY_INCREMENT = 100;

    @Override
    public boolean isValidDay(final LocalDate localDate) {
        if (localDate.isAfter(START_DAY) && localDate.isBefore(END_DAY)) {
            return true;
        }
        return false;
    }

    @Override
    public int applyDiscount(final Orders orders, final LocalDate localDate) {
        if (!isValidDay(localDate)) {
            return 0;
        }
        return BASE_DISCOUNT + (localDate.compareTo(START_DAY)) * DAILY_INCREMENT;
    }

    @Override
    public String getName() {
        return NAME;
    }

}
