package christmas.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Benefits implements Iterable<Benefit> {
    private List<Benefit> benefits;

    public Benefits() {
        this.benefits = new ArrayList<>();
    }

    public void add(Benefit benefit) {
        benefits.add(benefit);
    }

    public int size() {
        return benefits.size();
    }


    public int getTotalBenefits() {
        int totalBenefits = 0;
        for (Benefit benefit : benefits) {
            totalBenefits += benefit.getPrice();
        }
        return totalBenefits;
    }

    @Override
    public Iterator<Benefit> iterator() {
        return benefits.iterator();
    }
}
