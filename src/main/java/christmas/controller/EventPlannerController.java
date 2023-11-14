package christmas.controller;

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
        EventPlanner eventPlanner = new EventPlanner(now);
        Benefits benefits = eventPlanner.getBenefits(orders);
        OutputView.printBenefitsInfo(benefits);

    }

    private static Orders askOrders() {
        OutputView.printInputOrderMessage();
        try {
            String[] orderValues = InputView.nextArrString();
            Orders orders = new Orders();
            for (String orderValue : orderValues) {
                orders.add(Order.parseOrder(orderValue));
            }
            return orders;
        } catch (IllegalArgumentException e) {
            return askOrders();
        }
    }

    private int askDay() {
        OutputView.printInputDayMessage();
        try {
            int day = InputView.nextDay(SystemConst.CURRENT_MONTH);
            return day;
        } catch (IllegalArgumentException e) {
            return askDay();
        }
    }
}
