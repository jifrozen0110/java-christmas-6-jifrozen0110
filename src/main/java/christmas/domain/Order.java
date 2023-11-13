package christmas.domain;

import christmas.common.consts.ErrorMessage;
import christmas.view.OutputView;
import java.util.Objects;

public class Order {
    public static final String REGEX = "-";
    private Menu menu;
    private int count;

    private Order(final Menu menu, final int count) {
        this.menu = menu;
        this.count = count;
    }

    public static Order of(String name, int count) {
        validate(name, count);
        return new Order(Menu.from(name), count);
    }

    public static Order parseOrder(String str) {
        String[] order = str.split(REGEX);
        if (order.length != 2) {
            OutputView.printErr(ErrorMessage.INVALID_INPUT_ORDER_ERROR.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_ERROR.getErrorMessage());
        }
        String name = order[0];
        int count;
        try {
            count = Integer.parseInt(order[1]);
        } catch (NumberFormatException e) {
            OutputView.printErr(ErrorMessage.INVALID_INPUT_ORDER_ERROR.getErrorMessage());
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

    private static void validate(final String name, final int count) {
        if (name == null) {
            OutputView.printErr(ErrorMessage.NULL_VALUE_ERROR.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE_ERROR.getErrorMessage());
        }

        if (count < 1) {
            OutputView.printErr(ErrorMessage.ZERO_VALUE_ERROR.getErrorMessage());
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
        return menu.getName().equals(((Order) obj).menu.getName());
    }

    @Override
    public String toString() {
        return menu.getName() + " " + count + "개";
    }

}
