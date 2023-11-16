package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class OrdersTest {

    @Test
    void 전부_음료_주문이면_IAE() {
        Orders orders = new Orders();
        orders.add(Order.of("레드와인", 1));
        orders.add(Order.of("샴페인", 2));
        orders.add(Order.of("제로콜라", 2));

        assertThrows(IllegalArgumentException.class, () -> orders.validate());
    }

    @Test
    void 주문수량이_20개_넘어가면_해당주문은_삭제() {
        Orders orders = new Orders();
        orders.add(Order.of("레드와인", 4));
        orders.add(Order.of("샴페인", 5));
        orders.add(Order.of("바비큐립", 10));
        orders.add(Order.of("타파스", 10));

        assertEquals(19, orders.size());
    }

    @Test
    void 중복된_주문이면_IAE() {
        Orders orders = new Orders();
        orders.add(Order.of("레드와인", 1));

        assertThrows(IllegalArgumentException.class, () -> orders.add(Order.of("레드와인", 2)));
    }

    @Test
    void 총_주문_가격_구하기() {
        Orders orders = new Orders();
        orders.add(Order.of("레드와인", 4));
        orders.add(Order.of("샴페인", 5));
        orders.add(Order.of("바비큐립", 10));

        int expectedTotalPrice =
                Menu.RED_WINE.getPrice() * 4 + Menu.CHAMPAGNE.getPrice() * 5 + Menu.BBQ_RIBS.getPrice() * 10;

        assertEquals(expectedTotalPrice, orders.getTotalPrice());
    }

}