package com.jpmc.theater;

import com.jpmc.theater.discount.DiscountCalculator;
import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {

    @Test
    void testSequenceDiscount1() {
        var customer = new Customer("John Doe", "unused-id");
        var movie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        var showing = new Showing(movie, 1, LocalDateTime.of(LocalDate.of(2023, 1, 1), LocalTime.of(9, 0)));
        Reservation reservation = new Reservation(customer, showing, 3, DiscountCalculator.INSTANCE);
        assertTrue(reservation.totalFee() == 28.5);
    }

    @Test
    void testSequenceDiscount2() {
        var customer = new Customer("John Doe", "unused-id");
        var movie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0);
        var showing = new Showing(movie, 2, LocalDateTime.of(LocalDate.of(2023, 1, 1), LocalTime.of(9, 0)));
        Reservation reservation = new Reservation(customer, showing, 3, DiscountCalculator.INSTANCE);
        assertTrue(reservation.totalFee() == 31.5);
    }

    @Test
    void testShowDateDiscount() {
        var customer = new Customer("John Doe", "unused-id");
        var movie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0);
        var showing = new Showing(movie, 3, LocalDateTime.of(LocalDate.of(2023, 1, 7), LocalTime.of(9, 0)));
        Reservation reservation = new Reservation(customer, showing, 1, DiscountCalculator.INSTANCE);
        assertTrue(reservation.totalFee() == 11.5);
    }

    @Test
    void testShowTimingDiscount1() {
        var customer = new Customer("John Doe", "unused-id");
        var movie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0);
        var showing = new Showing(movie, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)));
        Reservation reservation = new Reservation(customer, showing, 3, DiscountCalculator.INSTANCE);
        assertTrue(reservation.totalFee() == 28.125);
    }

    @Test
    void testShowTimingDiscount2() {
        var customer = new Customer("John Doe", "unused-id");
        var movie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0);
        var showing = new Showing(movie, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 0)));
        Reservation reservation = new Reservation(customer, showing, 1, DiscountCalculator.INSTANCE);
        assertTrue(reservation.totalFee() == 12.5);
    }

    @Test
    void testSpecialMovieDiscount() {
        var customer = new Customer("John Doe", "unused-id");
        var movie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        var showing = new Showing(movie, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        Reservation reservation = new Reservation(customer, showing, 3, DiscountCalculator.INSTANCE);
        assertTrue(reservation.totalFee() == 30);
    }

    @Test
    void testMultiDiscount() {
        var customer = new Customer("John Doe", "unused-id");
        var movie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        var showing = new Showing(movie, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        Reservation reservation = new Reservation(customer, showing, 3, DiscountCalculator.INSTANCE);
        assertTrue(reservation.totalFee() == 28.5);
    }

}
