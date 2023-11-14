package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventPlanner {
    private List<Event> events = new ArrayList<>();
    private List<Gift> gifts = new ArrayList<>();
    private Benefits benefits = new Benefits();
    private Orders giftOrders = new Orders();
    private final LocalDate date;
    private final Orders orders;

    public EventPlanner(final LocalDate date, final Orders orders) {
        this.date = date;
        this.orders = orders;
        initializeEvents();
        initializeGifts();
    }

    public Benefits getBenefits() {
        calculateEventBenefits();
        calculateGiftBenefits();
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

    private void initializeEvents() {
        events.add(new ChristmasEvent());
        events.add(new WeekdayEvent());
        events.add(new WeekendEvent());
        events.add(new StarEvent());
    }

    private void initializeGifts() {
        gifts.add(new DecemberGift());
    }

    private void calculateGiftBenefits() {
        for (Gift gift : gifts) {
            Menu giftMenu = gift.getGift(orders, date);
            if (giftMenu == null) {
                continue;
            }
            benefits.add(new Benefit(gift.getName(), giftMenu.getPrice()));
            giftOrders.add(Order.of(giftMenu.getName(), 1));
        }
    }

    private void calculateEventBenefits() {
        for (Event event : events) {
            int price = event.applyDiscount(orders, date);
            if (price == 0) {
                continue;
            }
            benefits.add(new Benefit(event.getName(), price));
        }
    }
}
