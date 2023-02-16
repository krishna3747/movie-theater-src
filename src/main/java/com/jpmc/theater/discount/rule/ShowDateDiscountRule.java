package com.jpmc.theater.discount.rule;

import com.jpmc.theater.model.Showing;

public class ShowDateDiscountRule implements DiscountRule {

    @Override
    public double applyDiscountRule(Showing showing) {
        if (showing.getStartTime().toLocalDate().getDayOfMonth() == 7) {
            return 1;  // $1 discount for movies showing on 7th
        }
        return 0;
    }

}
