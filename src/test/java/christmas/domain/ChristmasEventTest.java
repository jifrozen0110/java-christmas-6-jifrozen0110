package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import christmas.common.consts.SystemConst;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChristmasEventTest {
    private ChristmasEvent christmasEvent;
    private LocalDate duringEvent;
    private LocalDate beforeEvent;
    private LocalDate afterEvent;
    private Orders orders;

    @BeforeEach
    void setUp() {
        christmasEvent = new ChristmasEvent();
        duringEvent = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH, SystemConst.START_DAY + 6);
        beforeEvent = duringEvent.minusDays(3);
        afterEvent = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH, SystemConst.CHRISTMAS_DAY)
                .plusDays(1);
        orders = new Orders();
    }

    @Test
    void 이벤트_기간이_아니면_false를_반환() {
        assertFalse(christmasEvent.isValidDay(beforeEvent));
        assertFalse(christmasEvent.isValidDay(afterEvent));
    }

    @Test
    void 이벤트_최소_주문_금액을_못넘으면_false를_반환() {
        assertFalse(christmasEvent.validatePrice(orders));
    }

    @Test
    void 크리스마스_디데이_할인() {
        orders.add(Order.of("샴페인", 3));
        orders.add(Order.of("티본스테이크", 2));

        int expectedDiscountAmount = 1000 + (100 * 6);
        assertEquals(expectedDiscountAmount, christmasEvent.applyDiscount(orders, duringEvent));
    }

}