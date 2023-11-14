package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BenefitsTest {

    @Test
    void 총_혜택_금액을_반환한다() {
        Benefits benefits = new Benefits();
        benefits.add(Benefit.of("특별 할인", 1000));
        benefits.add(Benefit.of("주말 할인", 2000));

        assertEquals(3000, benefits.getTotalBenefits());
    }

}