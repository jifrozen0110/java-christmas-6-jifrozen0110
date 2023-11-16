package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import christmas.common.consts.SystemConst;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StarEventTest {
    private StarEvent starEvent;
    private LocalDate duringEvent;
    private LocalDate beforeEvent;
    private LocalDate afterEvent;
    private LocalDate eventDay;
    private Orders orders;

    @BeforeEach
    void setUp() {
        starEvent = new StarEvent();
        duringEvent = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH, SystemConst.START_DAY + 1);
        beforeEvent = duringEvent.minusDays(5);
        afterEvent = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH, SystemConst.DECEMBER_END_DAY)
                .plusDays(1);
        eventDay = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH, 3);
        orders = new Orders();
    }

    @Test
    void 이벤트_기간이_아니면_false를_반환() {
        assertFalse(starEvent.isValidDay(beforeEvent));
        assertFalse(starEvent.isValidDay(afterEvent));
        assertFalse(starEvent.isValidDay(eventDay.minusDays(1)));
    }

    @Test
    void 이벤트_최소_주문_금액을_못넘으면_false를_반환() {
        assertFalse(starEvent.validatePrice(orders));
    }

    @Test
    void 특별_할인() {
        orders.add(Order.of("초코케이크", 3));
        orders.add(Order.of("아이스크림", 2));

        int expectedDiscountAmount = 1000;
        assertEquals(expectedDiscountAmount, starEvent.applyDiscount(orders, eventDay));
    }
}