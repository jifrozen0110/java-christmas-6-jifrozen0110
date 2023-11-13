package christmas.view;

public class OutputView {
    private final static String GREETINGS_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final static String INPUT_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

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


}
