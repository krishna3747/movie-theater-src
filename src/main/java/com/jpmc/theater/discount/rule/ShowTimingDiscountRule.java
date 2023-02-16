package com.jpmc.theater.discount.rule;

import com.jpmc.theater.model.Showing;

import java.time.LocalTime;

public class ShowTimingDiscountRule implements DiscountRule {

    @Override
    public double applyDiscountRule(Showing showing) {
        if (showing.getStartTime().toLocalTime().isAfter(LocalTime.of(10, 59, 59))
                && showing.getStartTime().toLocalTime().isBefore(LocalTime.of(16, 0, 1))) {
            return showing.getMovie().getTicketPrice() * 0.25;  // 25% discount any movies showing starting between 11AM ~ 4pm
        }
        return 0;
    }

}
