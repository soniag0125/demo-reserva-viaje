package com.sguama.book_trip.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String origin;
    private String destination;
    private Integer capacity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Long price;
    private String status;
    @OneToMany(mappedBy = "flightEntity")
    private List<BookingEntity> bookingEntities;
}


