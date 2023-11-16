package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class OrderTest {
    private static Stream<Arguments> provideStringAndOrder() {
        return Stream.of(
                Arguments.of("타파스-1", Order.of("타파스", 1)),
                Arguments.of("레드와인-3", Order.of("레드와인", 3))
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringAndOrder")
    void Order가_정상적으로_생성되는_경우(String input, Order order) {
        Order generateOrder = Order.parseOrder(input);

        assertTrue(order.equals(generateOrder));
        assertEquals(order.getCount(), generateOrder.getCount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"바나나킥-1", "그냥", "레드와인-0"})
    void 유효하지_않은_값들이_들어오면_IAE(String invalidInput) {
        assertThrows(IllegalArgumentException.class, () -> Order.parseOrder(invalidInput));
    }

    @Test
    void 메뉴당_총_가격을_받아오는지_검사() {
        Order order = Order.of("타파스", 2);

        int expectedPrice = Menu.TAPAS.getPrice() * 2;

        assertEquals(expectedPrice, order.getPrice());
    }

    @Test
    void 메뉴_이름이_같으면_True() {
        Order order1 = Order.of("타파스", 2);
        Order order2 = Order.of("타파스", 1);

        assertTrue(order1.equals(order2));
    }

}