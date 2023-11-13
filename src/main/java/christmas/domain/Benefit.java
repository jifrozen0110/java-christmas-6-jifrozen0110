package christmas.domain;

public class Benefit {
    private final String name;
    private final int price;

    public Benefit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
