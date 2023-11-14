package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventPlanner {
    private List<Event> events = new ArrayList<>();
    private List<Gift> gifts = new ArrayList<>();
    private Benefits benefits = new Benefits();
    private Orders giftOrders = new Orders();
    private LocalDate date;
    private Orders orders;

    public EventPlanner(LocalDate date, Orders orders) {
        this.date = date;
        this.orders = orders;
        events.add(new ChrismasEvent());
        events.add(new WeekdayEvent());
        events.add(new WeekendEvent());
        events.add(new StarEvent());
        gifts.add(new DecemberGift());
    }

    public Benefits getBenefits() {
        for (Event event : events) {
            int price = event.applyDiscount(orders, date);
            if (price == 0) {
                continue;
            }
            benefits.add(new Benefit(event.getName(), price));
        }

        for (Gift gift : gifts) {
            Menu giftMenu = gift.getGift(orders, date);
            benefits.add(new Benefit(gift.getName(), giftMenu.getPrice()));
            giftOrders.add(Order.of(giftMenu.getName(), 1));
        }
        return benefits;
    }

    public Orders getGifts() {
        return giftOrders;
    }

    public Badge getBadge() {
        int totalBenefitsPrice = benefits.getTotalBenefits();
        for (Badge badge : Badge.values()) {
            if (badge.getPrice() <= totalBenefitsPrice) {
                return badge;
            }
        }
        return null;
    }

    public int getTotalPriceArfterBenefits() {
        return orders.getTotalPrice() - benefits.getTotalBenefits() + giftOrders.getTotalPrice();
    }

}
