package com.sguama.book_trip.web.controllers;

import com.sguama.book_trip.domain.model.Booking;
import com.sguama.book_trip.domain.usecases.BookingFlightService;
import com.sguama.book_trip.domain.usecases.UpdateBookingService;
import com.sguama.book_trip.web.dto.BookingRequest;
import com.sguama.book_trip.web.dto.BookingUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/booking")
public class BookingController {

    @Autowired
    private BookingFlightService bookingFlightService;

    @Autowired
    private UpdateBookingService updateBookingService;

    @PostMapping("/create/v1")
    public ResponseEntity<Booking> addBooking(@RequestBody BookingRequest request) {
         return new ResponseEntity<>(createBooking(request), HttpStatus.CREATED);
    }

    @PutMapping("/update/v1")
    public ResponseEntity<Booking> updateBooking(@RequestBody BookingUpdate request) {
       Booking booking = updateBookingService.updateBooking(
               request.getBookingId(), request.getFlightId());
        return ResponseEntity.ok(createBooking(createBookingRequest(booking, request)));
    }

    @GetMapping("/list/v1")
    public List<Booking> getAllActiveFlights() {
        return bookingFlightService.getBookings();
    }

    private Booking createBooking(BookingRequest bookingRequest){
        return bookingFlightService.createBooking(
                bookingRequest.getFlightId(), bookingRequest.getUserName());
    }

    private BookingRequest createBookingRequest(Booking booking, BookingUpdate request){
        return BookingRequest.builder()
                .userName(booking.getUserName())
                .flightId(request.getFlightId())
                .build();
    }

}
