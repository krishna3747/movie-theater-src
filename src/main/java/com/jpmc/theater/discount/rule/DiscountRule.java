package com.jpmc.theater.discount.rule;

import com.jpmc.theater.model.Showing;

public interface DiscountRule {

    double applyDiscountRule(Showing showing);

}
