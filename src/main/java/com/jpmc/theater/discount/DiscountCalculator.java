package com.jpmc.theater.discount;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.discount.rule.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * Calculate discount based on certain defined rules
 */
public enum DiscountCalculator {
    INSTANCE;

    /**
     * This can be further optimized by using Spring auto-wiring
     */
    private final Collection<DiscountRule> discountRules = Arrays.asList(
            new SequenceDiscountRule(),
            new ShowDateDiscountRule(),
            new ShowTimingDiscountRule(),
            new SpecialMovieDiscount()
    );

    /**
     * Calculate discount for the given movie and showtime.
     * It uses list of predefined discount rules to find the right discount.
     *
     * @param showing
     * @return discount
     */
    public double calculateDiscount(Showing showing) {
        double maximumDiscount = 0;
        for (DiscountRule rule : discountRules) {
            double discount = rule.applyDiscountRule(showing);
            if (discount > maximumDiscount) {
                maximumDiscount = discount;
            }
        }
        return maximumDiscount;
    }

}
