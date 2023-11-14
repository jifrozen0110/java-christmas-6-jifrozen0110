package christmas.domain;

import christmas.common.consts.SystemConst;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class StarEvent implements Event {
    private static final String NAME = "특별 할인";
    private static final LocalDate START_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.START_DAY);
    private static final LocalDate END_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.DECEMBER_END_DAY);
    private static final int BASE_DISCOUNT = 1000;

    @Override
    public boolean isValidDay(final LocalDate localDate) {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        if (!localDate.isAfter(START_DAY) || !localDate.isBefore(END_DAY)) {
            return false;
        }
        if (dayOfWeek == DayOfWeek.SUNDAY) {
            return true;
        }
        if (localDate.getDayOfMonth() == SystemConst.CHRISTMAS_DAY) {
            return true;
        }
        return false;
    }

    @Override
    public int applyDiscount(final Orders orders, final LocalDate localDate) {
        if (!isValidDay(localDate)) {
            return 0;
        }
        return BASE_DISCOUNT;
    }

    @Override
    public String getName() {
        return NAME;
    }
}