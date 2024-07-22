package com.sguama.book_trip.domain.usecases;

import com.sguama.book_trip.application.interfaces.IBookingRepository;
import com.sguama.book_trip.application.interfaces.IFlightRepository;
import com.sguama.book_trip.application.util.ResourceNotFoundException;
import com.sguama.book_trip.domain.model.Booking;
import com.sguama.book_trip.domain.model.Flight;
import org.springframework.stereotype.Component;

import static com.sguama.book_trip.domain.common.Constants.CANCELLED_BOOKING;
import static com.sguama.book_trip.domain.common.Constants.CONFIRMED_BOOKING;
import static com.sguama.book_trip.domain.common.Util.isNull;

@Component
public class UpdateBookingService {



    private final IFlightRepository repositoryFlights;
    private final IBookingRepository repositoryBookings;

    public UpdateBookingService(IBookingRepository repositoryBookings, IFlightRepository repositoryFlights) {
        this.repositoryBookings = repositoryBookings;
        this.repositoryFlights = repositoryFlights;
    }

    public Booking updateBooking(Long bookingId, Long flightId) {
        System.out.println("Updating Booking " + bookingId + " with flight " + flightId);
        Booking booking = repositoryBookings.getBookingById(bookingId);
        Flight flight = repositoryFlights.getFlightById(flightId);
        if (isNull.test(flight)) {
            throw new ResourceNotFoundException("Is not a book available");

        } else {
            booking.setStatus(CANCELLED_BOOKING);
            repositoryBookings.save(booking);
            return booking;
        }
    }

    public void confirmedBooking(Long bookingId) {
        Booking booking = repositoryBookings.getBookingById(bookingId);
        booking.setStatus(CONFIRMED_BOOKING);
        repositoryBookings.save(booking);
    }
}
