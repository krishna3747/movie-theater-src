package com.jpmc.theater;

import com.jpmc.theater.discount.DiscountCalculator;
import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Showing;

public class Reservation {
    private final Customer customer;
    private final Showing showing;
    private final int audienceCount;
    private final DiscountCalculator discountCalculator;

    public Reservation(Customer customer, Showing showing, int audienceCount, DiscountCalculator discountCalculator) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
        this.discountCalculator = discountCalculator;
    }

    public double totalFee() {
        double discount = discountCalculator.calculateDiscount(showing);
        System.out.println("Calculated discount is " + discount);
        double ticketPrice = showing.getMovieFee() - discount;
        return ticketPrice * audienceCount;
    }

}