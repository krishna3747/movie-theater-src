package com.jpmc.theater.discount.rule;

import com.jpmc.theater.model.Showing;

public class SpecialMovieDiscount implements DiscountRule {

    private static final int MOVIE_CODE_SPECIAL = 1;

    @Override
    public double applyDiscountRule(Showing showing) {
        if (MOVIE_CODE_SPECIAL == showing.getMovie().getSpecialCode()) {
            return showing.getMovieFee() * 0.2;  // 20% discount for special movie
        }
        return 0;
    }

}
