package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventPlanner {
    private List<Event> events = new ArrayList<>();
    private Benefits benefits = new Benefits();
    private LocalDate date;

    public EventPlanner(LocalDate date) {
        this.date = date;
        events.add(new ChrismasEvent());
        events.add(new WeekdayEvent());
        events.add(new WeekendEvent());
        events.add(new StarEvent());
    }

    public Benefits getBenefits(Orders orders) {
        for (Event event : events) {
            int price = event.applyDiscount(orders, date);
            if (price == 0) {
                continue;
            }
            benefits.add(new Benefit(event.getName(), price));
        }
        return benefits;
    }

    public int getTotalPriceArfterBenefits(Orders orders) {
        return orders.getTotalPrice() - benefits.getTotalBenefits();
    }

}
