package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import christmas.common.consts.SystemConst;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeekdayEventTest {
    private WeekdayEvent weekdayEvent;
    private LocalDate duringEvent;
    private LocalDate beforeEvent;
    private LocalDate afterEvent;
    private LocalDate fridayDate;
    private Orders orders;

    @BeforeEach
    void setUp() {
        weekdayEvent = new WeekdayEvent();
        duringEvent = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH, SystemConst.START_DAY + 4);
        beforeEvent = duringEvent.minusDays(5);
        afterEvent = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH, SystemConst.DECEMBER_END_DAY)
                .plusDays(1);
        fridayDate = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH, 8);
        orders = new Orders();
    }

    @Test
    void 이벤트_기간이_아니면_false를_반환() {
        assertFalse(weekdayEvent.isValidDay(beforeEvent));
        assertFalse(weekdayEvent.isValidDay(afterEvent));
        assertFalse(weekdayEvent.isValidDay(fridayDate));
    }

    @Test
    void 이벤트_최소_주문_금액을_못넘으면_false를_반환() {
        assertFalse(weekdayEvent.validatePrice(orders));
    }

    @Test
    void 크리스마스_디데이_할인() {
        orders.add(Order.of("초코케이크", 3));
        orders.add(Order.of("아이스크림", 2));

        int expectedDiscountAmount = 2023 * 5;
        assertEquals(expectedDiscountAmount, weekdayEvent.applyDiscount(orders, duringEvent));
    }
}