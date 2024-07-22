package com.sguama.book_trip.infrastructure.entity.mappers;

import com.sguama.book_trip.domain.model.Booking;
import com.sguama.book_trip.infrastructure.entity.BookingEntity;
import com.sguama.book_trip.infrastructure.entity.FlightEntity;

public class BookingMapper {

    public static Booking entityToDomain(BookingEntity bookingEntity){
        return Booking.builder()
                .id(bookingEntity.getId())
                .bookDate(bookingEntity.getBookDate())
                .flightId(bookingEntity.getFlightEntity().getId())
                .status(bookingEntity.getStatus())
                .userName(bookingEntity.getUserName())
                .build();
    }

    public static BookingEntity domainToEntity(Booking booking){
        return BookingEntity.builder()
                .id(booking.getId())
                .userName(booking.getUserName())
                .bookDate(booking.getBookDate())
                .flightEntity(FlightEntity.builder()
                        .id(booking.getFlightId())
                        .build())
                .bookDate(booking.getBookDate())
                .status(booking.getStatus())
                .build();
    }
}
