package christmas.domain;

public interface Event {

    boolean isValidDay(int month, int day);

    int applyDiscount(Orders orders, int day, int month);

    String getName();
}
