package christmas.domain;

import christmas.common.consts.ErrorMessage;
import christmas.view.OutputView;

public class Benefit {
    private final String name;
    private final int price;

    private Benefit(final String name, final int price) {
        validate(name, price);
        this.name = name;
        this.price = price;
    }

    private void validate(String name, int price) {
        if (name == null) {
            OutputView.printErr(ErrorMessage.NULL_VALUE_ERROR.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE_ERROR.getErrorMessage());
        }
        if (price <= 0) {
            OutputView.printErr(ErrorMessage.NULL_VALUE_ERROR.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE_ERROR.getErrorMessage());
        }
    }

    public static Benefit of(String name, int price) {
        return new Benefit(name, price);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
