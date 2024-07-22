package com.sguama.book_trip.infrastructure.respositories;

import com.sguama.book_trip.infrastructure.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightJpaRepository extends JpaRepository<FlightEntity, Long> {
}
