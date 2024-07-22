package com.sguama.book_trip.domain.usecases;


import com.sguama.book_trip.application.interfaces.IBookingRepository;
import com.sguama.book_trip.application.interfaces.IFlightRepository;
import com.sguama.book_trip.application.util.ResourceNotFoundException;
import com.sguama.book_trip.domain.model.Booking;
import com.sguama.book_trip.domain.model.Flight;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

import static com.sguama.book_trip.domain.common.Constants.ACTIVE_BOOKING;
import static com.sguama.book_trip.domain.common.Util.isNull;

@Component
public class BookingFlightService {



    private final IFlightRepository repositoryFlights;
    private final IBookingRepository repositoryBookings;


    public BookingFlightService(
            IFlightRepository repositoryFlights, IBookingRepository repositoryBookings) {
        this.repositoryFlights = repositoryFlights;
        this.repositoryBookings = repositoryBookings;
    }

    public Booking createBooking(Long flightId, String userName) {
        Flight flight = repositoryFlights.getFlightById(flightId);
        if (isNull.test(flight)) {
            throw new ResourceNotFoundException("Is not a book available");
        } else {
            Booking booking = Booking.builder()
                    .flightId(flightId)
                    .userName(userName)
                    .bookDate(LocalDateTime.now())
                    .status(ACTIVE_BOOKING)
                    .build();
            repositoryBookings.save(booking);
            return booking;
        }
    }

    public List<Booking> getBookings() {
        return repositoryBookings.getAllActiveBookings();
    }

}
