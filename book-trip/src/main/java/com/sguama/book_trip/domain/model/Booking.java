package com.sguama.book_trip.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class Booking {

    private Long id;
    private Long flightId;
    private String userName;
    private LocalDateTime bookDate;
    private String status;

}
