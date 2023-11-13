package christmas.domain;

import christmas.common.consts.SystemConst;
import java.util.ArrayList;
import java.util.List;

public class EventPlanner {
    private List<Event> events = new ArrayList<>();
    private List<Benefit> benefits = new ArrayList<>();
    private int day;

    public EventPlanner(int day) {
        this.day = day;
        events.add(new ChrismasEvent());
    }

    public List<Benefit> getBenefits(Orders orders) {
        for (Event event : events) {
            int price = event.applyDiscount(orders, day, SystemConst.CURRENT_MONTH);
            if (price == 0) {
                continue;
            }
            benefits.add(new Benefit(event.getName(), price));
        }
        return benefits;
    }

}
