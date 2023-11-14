package christmas.view;

import christmas.common.utils.CurrencyUtil;
import christmas.domain.Badge;
import christmas.domain.Benefit;
import christmas.domain.Benefits;
import christmas.domain.Orders;
import java.time.LocalDate;

public class OutputView {
    public static final String NOTHING = "없음";
    private static final String GREETINGS_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String INPUT_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String PREVIEW_OF_EVENT_MESSAGE = "%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_LIST_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_PRICE_BEFORE_EVENTS_MESSAGE = "<할인 전 총주문 금액>";
    private static final String BENEFITS_LIST_MESSAGE = "<혜택 내역>";
    private static final String TOTAL_BENEFITS_PRICE_MESSAGE = "<총혜택 금액>";
    private static final String ESTIMATED_PRICE_AFTER_DISCOUNT_MESSAGE = "<할인 후 예상 결제 금액>";
    private static final String DECEMBER_EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>";
    private static final String GIFT_MENU_MESSAGE = "<증정 메뉴>";


    public static void print(final String text) {
        System.out.print(text);
    }

    public static void println(final String text) {
        System.out.println(text);
    }

    public static void println() {
        System.out.println();
    }

    public static void printErr(final String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printGreetingsMessage() {
        println(GREETINGS_MESSAGE);
    }

    public static void printInputDayMessage() {
        println(INPUT_DAY_MESSAGE);
    }

    public static void printInputOrderMessage() {
        println(INPUT_ORDER_MESSAGE);
    }

    public static void printPreviewOfEventMessage(final LocalDate date) {
        println(String.format(PREVIEW_OF_EVENT_MESSAGE, date.getMonthValue(), date.getDayOfMonth()));
        println();
    }

    public static void printOrderMenuList(final Orders orders) {
        println(ORDER_MENU_LIST_MESSAGE);
        print(orders.toString());
        println();
    }

    public static void printTotalOrdersPrice(final Orders orders) {
        println(TOTAL_PRICE_BEFORE_EVENTS_MESSAGE);
        println(CurrencyUtil.fromToKRW(orders.getTotalPrice()));
        println();
    }

    public static void printBenefitsInfo(final Benefits benefits) {
        println(BENEFITS_LIST_MESSAGE);
        if (benefits.size() == 0) {
            println(NOTHING);
            println();
            return;
        }
        for (Benefit benefit : benefits) {
            println(benefit.getName() + ": -" + CurrencyUtil.fromToKRW(benefit.getPrice()));
        }
        println();
    }

    public static void printTotalBenefitsPrice(final Benefits benefits) {
        println(TOTAL_BENEFITS_PRICE_MESSAGE);
        if (benefits.getTotalBenefits() != 0) {
            print("-");
        }
        println(CurrencyUtil.fromToKRW(benefits.getTotalBenefits()));
        println();
    }

    public static void printEstimatedPriceAfterDiscount(final int amount) {
        println(ESTIMATED_PRICE_AFTER_DISCOUNT_MESSAGE);
        println(CurrencyUtil.fromToKRW(amount));
        println();
    }

    public static void printDecemberEventBadge(final Badge badge) {
        println(DECEMBER_EVENT_BADGE_MESSAGE);
        if (badge == null) {
            println(NOTHING);
            println();
            return;
        }
        println(badge.getName());
    }

    public static void printGiftMenu(final Orders orders) {
        println(GIFT_MENU_MESSAGE);
        if (orders.size() == 0) {
            println(NOTHING);
            println();
            return;
        }
        println(orders.toString());
    }

}
