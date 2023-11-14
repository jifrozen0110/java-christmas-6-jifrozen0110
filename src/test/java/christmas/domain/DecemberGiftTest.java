package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import christmas.common.consts.SystemConst;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecemberGiftTest {
    private DecemberGift decemberGift;
    private LocalDate duringEvent;
    private LocalDate beforeEvent;
    private LocalDate afterEvent;
    private Orders orders;

    @BeforeEach
    void setUp() {
        decemberGift = new DecemberGift();
        duringEvent = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH, SystemConst.START_DAY + 1);
        beforeEvent = duringEvent.minusDays(5);
        afterEvent = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH, SystemConst.DECEMBER_END_DAY)
                .plusDays(1);
        orders = new Orders();
    }

    @Test
    void 이벤트_기간이_아니면_false를_반환() {
        assertFalse(decemberGift.isValidDay(beforeEvent));
        assertFalse(decemberGift.isValidDay(afterEvent));
    }

    @Test
    void 이벤트_최소_주문_금액을_못넘으면_false를_반환() {
        assertFalse(decemberGift.validatePrice(orders));
    }

    @Test
    void 증정이벤트_얻음() {
        orders.add(Order.of("티본스테이크", 3));
        orders.add(Order.of("아이스크림", 2));

        assertEquals(Menu.CHAMPAGNE, decemberGift.getGift(orders, duringEvent));
    }
}