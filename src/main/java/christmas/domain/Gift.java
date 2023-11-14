package christmas.domain;

import java.time.LocalDate;

public interface Gift {

    boolean isValidDay(LocalDate localDate);

    Menu getGift(Orders orders, LocalDate localDate);

    String getName();
}
