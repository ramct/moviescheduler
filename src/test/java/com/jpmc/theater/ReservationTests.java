package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class ReservationTests {

    @Test
    void totalFee() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.now()
        );
        double result = new Reservation(customer, showing, 3).totalFee();
        assertEquals(28.5, result);
    }
}
