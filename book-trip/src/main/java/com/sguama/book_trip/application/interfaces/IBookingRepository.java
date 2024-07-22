package com.sguama.book_trip.application.interfaces;

import com.sguama.book_trip.domain.model.Booking;

import java.util.List;

public interface IBookingRepository {

    Booking getBookingById(Long id);
    void save(Booking booking);
        List<Booking> getAllActiveBookings();
}
