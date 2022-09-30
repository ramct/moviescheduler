package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TheaterTests {
    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater(LocalDateProvider.getInstance());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
        assertEquals(50, reservation.totalFee());
    }

    @Test
    void printMovieSchedule() {
        Theater theater = new Theater(LocalDateProvider.getInstance());
        assertTrue(!theater.printScheduleAsString().isEmpty());
        assertTrue(!theater.printScheduleAsJson().isEmpty());
    }
}
