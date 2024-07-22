package com.sguama.book_trip.domain;

import com.sguama.book_trip.application.interfaces.IBookingRepository;
import com.sguama.book_trip.application.interfaces.IFlightRepository;
import com.sguama.book_trip.domain.model.Booking;
import com.sguama.book_trip.domain.model.Flight;
import com.sguama.book_trip.domain.usecases.BookingFlightService;
import com.sguama.book_trip.domain.usecases.UpdateBookingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static com.sguama.book_trip.domain.common.Constants.ACTIVE_BOOKING;
import static com.sguama.book_trip.domain.common.Constants.CANCELLED_BOOKING;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateBookingServiceTest {

    @Test
    void shouldUpdateBooking() {
        IFlightRepository mockFlightRepository = Mockito.mock(IFlightRepository.class);
        IBookingRepository mockBookingRepository = Mockito.mock(IBookingRepository.class);

        Booking bookingCreated = new Booking(1L, 1L, "Sonia", LocalDateTime.now(), ACTIVE_BOOKING);
        Flight flight = new Flight(1L, "Quito", "Cuenca", LocalDateTime.now(), 10, 100L);
        Mockito.when(mockFlightRepository.getFlightById(1L)).thenReturn(flight);
        Mockito.when(mockBookingRepository.getBookingById(1l)).thenReturn(bookingCreated);

        UpdateBookingService useCase = new UpdateBookingService(mockBookingRepository, mockFlightRepository);
        Booking booking = useCase.updateBooking(1L, 1L);

        assertEquals(booking.getStatus(), CANCELLED_BOOKING);
        Mockito.verify(mockFlightRepository).getFlightById(1L);
    }
}
