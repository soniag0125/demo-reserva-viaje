package com.sguama.book_trip.infrastructure.adapters;

import com.sguama.book_trip.application.interfaces.IBookingRepository;
import com.sguama.book_trip.domain.model.Booking;
import com.sguama.book_trip.infrastructure.entities.BookingEntity;
import com.sguama.book_trip.infrastructure.entities.mappers.BookingMapper;
import com.sguama.book_trip.infrastructure.respositories.BookingJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.sguama.book_trip.domain.common.Constants.CANCELLED_BOOKING;

@Repository
public class BookingRepositoryJpa implements IBookingRepository {


    @Autowired
    private BookingJpaRepository bookingJpaRepository;

    @Override
    public Booking getBookingById(Long id) {
        BookingEntity bookingEntity =
                bookingJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("No found"));
        return  BookingMapper.entityToDomain(bookingEntity);
    }

    @Override
    public void save(Booking booking) {
        BookingEntity bookingEntity = BookingMapper.domainToEntity(booking);
        bookingJpaRepository.save(bookingEntity);
    }

    @Override
    public List<Booking> getAllActiveBookings() {
        List<BookingEntity> bookingEntities = bookingJpaRepository.findAll();
        List<Booking> list = new ArrayList<>();
        for (BookingEntity booking : bookingEntities) {
            if (!booking.getStatus().equals(CANCELLED_BOOKING)) {
                list.add(BookingMapper.entityToDomain(booking));
            }
        }
        return list;
    }

}
