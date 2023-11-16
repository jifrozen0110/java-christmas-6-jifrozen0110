package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EventPlannerTest {
    private static Stream<Arguments> provideLocalDateAndOrders() {
        return Stream.of(
                Arguments.of(LocalDate.of(2023, 12, 2), new Orders(new HashSet<>(
                        Arrays.asList(Order.of("타파스", 1), Order.of("제로콜라", 1)))), 0),
                Arguments.of(LocalDate.of(2023, 12, 4), new Orders(new HashSet<>(
                        Arrays.asList(Order.of("티본스테이크", 1), Order.of("제로콜라", 1)))), 1300),
                Arguments.of(LocalDate.of(2023, 12, 4), new Orders(new HashSet<>(
                        Arrays.asList(Order.of("티본스테이크", 1), Order.of("제로콜라", 1), Order.of("초코케이크", 1)))), 2023 + 1300),
                Arguments.of(LocalDate.of(2023, 12, 9), new Orders(new HashSet<>(
                        Arrays.asList(Order.of("티본스테이크", 1), Order.of("제로콜라", 1)))), 2023 + 1800),
                Arguments.of(LocalDate.of(2023, 12, 10), new Orders(new HashSet<>(
                        Arrays.asList(Order.of("티본스테이크", 1), Order.of("제로콜라", 1)))), 1900 + 1000),
                Arguments.of(LocalDate.of(2023, 12, 9), new Orders(new HashSet<>(
                        Arrays.asList(Order.of("티본스테이크", 3), Order.of("제로콜라", 1)))), 2023 * 3 + 25000 + 1800),
                Arguments.of(LocalDate.of(2023, 12, 28), new Orders(new HashSet<>(
                        Arrays.asList(Order.of("아이스크림", 5), Order.of("제로콜라", 1)))), 2023 * 5)
        );
        // 1. 할인을 못받는 경우
        // 2. 크리스마스 디데이 할인민
        // 3. 크리스마스 디데이 할인 + 평일 할인
        // 3. 크리스마스 디데이 할인 + 평일 할인 + 특별할인
        // 4. 크리스마스 디데이 할인 + 주말 할인 + 증정 이벤트
        // 5. 평일 할인
    }

    @ParameterizedTest
    @MethodSource("provideLocalDateAndOrders")
    void 혜택내역을_가져옵니다(LocalDate date, Orders orders, int totalPrice) {
        EventPlanner eventPlanner = new EventPlanner(date, orders);

        Benefits benefits = eventPlanner.getBenefits();

        assertEquals(totalPrice, benefits.getTotalBenefits());
    }

    @ParameterizedTest
    @MethodSource("provideLocalDateAndOrders")
    void 이벤트_배지를_얻는다(LocalDate date, Orders orders, int totalPrice) {
        EventPlanner eventPlanner = new EventPlanner(date, orders);
        int totalBenefitPrice = eventPlanner.getBenefits().getTotalBenefits();
        if (totalBenefitPrice >= 20000) {
            System.out.println(totalBenefitPrice);
            assertEquals(Badge.SANTA, eventPlanner.getBadge());
            return;
        } else if (totalBenefitPrice >= 10000) {
            assertEquals(Badge.TREE, eventPlanner.getBadge());
            return;
        } else if (totalBenefitPrice >= 5000) {
            assertEquals(Badge.STAR, eventPlanner.getBadge());
            return;
        }
        assertEquals(null, eventPlanner.getBadge());

    }

    @ParameterizedTest
    @MethodSource("provideLocalDateAndOrders")
    void 혜택_적용한_주문금액을_얻는다(LocalDate date, Orders orders, int totalPrice) {
        EventPlanner eventPlanner = new EventPlanner(date, orders);
        int totalBenefitPrice = eventPlanner.getBenefits().getTotalBenefits();
        int giftOrdersPrice = eventPlanner.getGifts().getTotalPrice();
        assertEquals(orders.getTotalPrice() - totalBenefitPrice + giftOrdersPrice,
                eventPlanner.getTotalPriceArfterBenefits());

    }
}