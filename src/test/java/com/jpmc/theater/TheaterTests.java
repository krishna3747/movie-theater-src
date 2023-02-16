package com.jpmc.theater;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.schedule.format.ScheduleFormat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TheaterTests {

    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater();
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
        assertEquals(reservation.totalFee(), 37.5);
    }

    @Test
    void printMovieScheduleText() {
        Theater theater = new Theater();
        theater.printSchedule(ScheduleFormat.TEXT);
    }

    @Test
    void printMovieScheduleJson() {
        Theater theater = new Theater();
        theater.printSchedule(ScheduleFormat.JSON);
    }

}
