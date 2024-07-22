package com.sguama.client.controllers;

import com.sguama.client.models.Booking;
import com.sguama.client.models.BookingRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("api/booking")
public class BookingController {

    @PostMapping("/create/v1")
    public ResponseEntity<Booking> addBooking(@RequestBody BookingRequest request) {
        Booking booking = new Booking();
        booking.setId(5L);
        booking.setFlightId(1L);
        booking.setUserName("Sonia");
        booking.setBookDate(LocalDateTime.now());
        booking.setStatus("ACTIVE");
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}
