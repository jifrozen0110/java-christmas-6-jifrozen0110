package christmas.domain;

import christmas.common.consts.ErrorMessage;
import christmas.view.OutputView;
import java.util.HashSet;
import java.util.Iterator;

public class Orders implements Iterable<Order> {
    private static final int MAX_ORDER_SIZE = 20;
    private final HashSet<Order> orders;

    public Orders() {
        this.orders = new HashSet<>();
    }

    public void add(Order order) {
        if (size() + order.getCount() > MAX_ORDER_SIZE) {
            OutputView.printErr(ErrorMessage.OUT_BOUND_OF_MAX_ORDER_ERROR.getErrorMessage());
            return;
        }

        boolean isAdded = orders.add(order);
        if (!isAdded) {
            OutputView.printErr(ErrorMessage.INVALID_INPUT_ORDER_ERROR.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ORDER_ERROR.getErrorMessage());
        }
    }

    public int size() {
        int size = 0;
        for (Order order : orders) {
            size += order.getCount();
        }
        return size;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Order order : orders) {
            totalPrice += order.getPrice();
        }
        return totalPrice;
    }

    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orders) {
            sb.append(order.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
