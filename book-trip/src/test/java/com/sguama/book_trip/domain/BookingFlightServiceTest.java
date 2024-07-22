package com.sguama.book_trip.domain;

import com.sguama.book_trip.application.interfaces.IBookingRepository;
import com.sguama.book_trip.application.interfaces.IFlightRepository;
import com.sguama.book_trip.domain.model.Booking;
import com.sguama.book_trip.domain.model.Flight;
import com.sguama.book_trip.domain.usecases.BookingFlightService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static com.sguama.book_trip.domain.common.Constants.ACTIVE_BOOKING;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingFlightServiceTest {

    @Test
    void shouldSaveBooking() {
        IFlightRepository mockFlightRepository = Mockito.mock(IFlightRepository.class);
        IBookingRepository mockBookingRepository = Mockito.mock(IBookingRepository.class);

        Flight flight = new Flight(1L, "Quito", "Cuenca", LocalDateTime.now(), 10, 100L);
        Mockito.when(mockFlightRepository.getFlightById(1L)).thenReturn(flight);

        BookingFlightService useCase = new BookingFlightService(mockFlightRepository, mockBookingRepository);
        Booking booking = useCase.createBooking(1L, "Sonia");

        assertEquals(booking.getStatus(), ACTIVE_BOOKING);
        Mockito.verify(mockFlightRepository).getFlightById(1L);
    }
}
