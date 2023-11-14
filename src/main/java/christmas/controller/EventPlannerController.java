package christmas.controller;

import christmas.common.consts.ErrorMessage;
import christmas.common.consts.SystemConst;
import christmas.domain.Benefits;
import christmas.domain.EventPlanner;
import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.time.LocalDate;

public class EventPlannerController {
    public void start() {
        OutputView.printGreetingsMessage();
        int day = askDay();
        LocalDate now = LocalDate.of(SystemConst.CURRENT_YEAR, SystemConst.CURRENT_MONTH, day);
        Orders orders = askOrders();
        OutputView.printPreviewOfEventMessage(now);
        OutputView.printOrderMenuList(orders);
        OutputView.printTotalOrdersPrice(orders);
        EventPlanner eventPlanner = new EventPlanner(now, orders);
        OutputView.printGiftMenu(eventPlanner.getGifts());
        Benefits benefits = eventPlanner.getBenefits();
        OutputView.printBenefitsInfo(benefits);
        OutputView.printTotalBenefitsPrice(benefits);
        OutputView.printEstimatedPriceAfterDiscount(eventPlanner.getTotalPriceArfterBenefits());
        OutputView.printDecemberEventBadge(eventPlanner.getBadge());
    }

    private static Orders askOrders() {
        OutputView.printInputOrderMessage();
        try {
            String[] orderValues = InputView.nextArrString();
            Orders orders = new Orders();
            for (String orderValue : orderValues) {
                Order order = Order.parseOrder(orderValue);
                orders.add(order);
            }
            orders.validate();
            return orders;
        } catch (IllegalArgumentException e) {
            OutputView.printErr(ErrorMessage.INVALID_INPUT_ORDER_ERROR.getErrorMessage());
            return askOrders();
        }
    }

    private int askDay() {
        OutputView.printInputDayMessage();
        try {
            int day = InputView.nextDay(SystemConst.CURRENT_MONTH);
            return day;
        } catch (IllegalArgumentException e) {
            OutputView.printErr(ErrorMessage.INVALID_DAY_INPUT_ERROR.getErrorMessage());
            return askDay();
        }
    }
}
