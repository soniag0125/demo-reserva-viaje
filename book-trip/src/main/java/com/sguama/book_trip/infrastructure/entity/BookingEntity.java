package com.sguama.book_trip.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookingEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String userName;
    private LocalDateTime bookDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flightEntity;
    @OneToOne(mappedBy = "bookingEntity", cascade = CascadeType.ALL)
    private NotificationEntity notificationEntity;
}
