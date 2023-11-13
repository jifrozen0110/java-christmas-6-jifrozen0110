package christmas.domain;

import christmas.common.consts.SystemConst;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayEvent implements Event {
    private static final String NAME = "평일 할인";
    private static final LocalDate START_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.START_DAY);
    private static final LocalDate END_DAY = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH,
            SystemConst.DECEMBER_END_DAY);

    @Override
    public boolean isValidDay(final LocalDate localDate) {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            return false;
        }
        if (!localDate.isAfter(START_DAY) || !localDate.isBefore(END_DAY)) {
            return false;
        }
        return true;
    }

    @Override
    public int applyDiscount(Orders orders, LocalDate localDate) {
        int totalDiscount = 0;
        for (Order order : orders) {
            if (order.getCategory() == Category.BEVERAGE) {
                totalDiscount += SystemConst.CURRENT_YEAR;
            }
        }
        return totalDiscount;
    }

    @Override
    public String getName() {
        return NAME;
    }
}