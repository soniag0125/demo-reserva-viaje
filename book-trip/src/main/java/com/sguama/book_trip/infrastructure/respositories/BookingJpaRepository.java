package com.sguama.book_trip.infrastructure.respositories;

import com.sguama.book_trip.infrastructure.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingJpaRepository  extends JpaRepository<BookingEntity, Long> {
}
