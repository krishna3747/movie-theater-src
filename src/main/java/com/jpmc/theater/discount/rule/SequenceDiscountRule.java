package com.jpmc.theater.discount.rule;

import com.jpmc.theater.model.Showing;

public class SequenceDiscountRule implements DiscountRule {

    @Override
    public double applyDiscountRule(Showing showing) {
        double sequenceDiscount = 0;
        if (showing.getSequenceOfTheDay() == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        } else if (showing.getSequenceOfTheDay() == 2) {
            sequenceDiscount = 2; // $2 discount for 2nd show
        }
        return sequenceDiscount;
    }

}
