package christmas.domain;

import java.time.LocalDate;

public interface Event {

    boolean validatePrice(Orders orders);

    boolean isValidDay(LocalDate localDate);

    int applyDiscount(Orders orders, LocalDate localDate);

    String getName();
}
