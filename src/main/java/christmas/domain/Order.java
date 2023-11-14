package christmas.domain;

import christmas.common.consts.ErrorMessage;
import java.util.Objects;

public class Order {
    public static final String REGEX = "-";
    private final Menu menu;
    private final int count;

    private Order(final Menu menu, final int count) {
        validate(menu, count);
        this.menu = menu;
        this.count = count;
    }

    public static Order of(String name, int count) {
        return new Order(christmas.domain.Menu.from(name), count);
    }

    public static Order parseOrder(final String str) {
        String[] order = str.split(REGEX);
        if (order.length != 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_ERROR.getErrorMessage());
        }
        String name = order[0];
        int count;
        try {
            count = Integer.parseInt(order[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_ERROR.getErrorMessage());
        }
        return of(name, count);
    }

    public int getCount() {
        return this.count;
    }

    public int getPrice() {
        return menu.getPrice() * count;
    }

    public Category getCategory() {
        return menu.getCategory();
    }

    private static void validate(final Menu menu, final int count) {
        if (menu == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE_ERROR.getErrorMessage());
        }
        if (count < 1) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_VALUE_ERROR.getErrorMessage());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(menu.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Order order = (Order) obj;
        return menu.getName().equals((order).menu.getName());
    }

    @Override
    public String toString() {
        return menu.getName() + " " + count + "개";
    }

}
