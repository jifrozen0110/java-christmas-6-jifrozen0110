package christmas.view;

public class OutputView {
    private static final String GREETINGS_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String INPUT_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String PREVIEW_OF_EVENT_MESSAGE = "%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    public static void print(final String text) {
        System.out.print(text);
    }

    public static void println(final String text) {
        System.out.println(text);
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

    public static void printPreviewOfEventMessage(int month, int day) {
        println(String.format(PREVIEW_OF_EVENT_MESSAGE, month, day));
    }

}
