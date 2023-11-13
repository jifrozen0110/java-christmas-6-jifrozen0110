package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventPlanner {
    private List<Event> events = new ArrayList<>();
    private List<Benefit> benefits = new ArrayList<>();
    private LocalDate date;

    public EventPlanner(LocalDate date) {
        this.date = date;
        events.add(new ChrismasEvent());
    }

    public List<Benefit> getBenefits(Orders orders) {
        for (Event event : events) {
            int price = event.applyDiscount(orders, date);
            if (price == 0) {
                continue;
            }
            benefits.add(new Benefit(event.getName(), price));
        }
        return benefits;
    }

}
