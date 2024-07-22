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
public class Flight {
    private Long id;
    private String origin;
    private String destination;
    private LocalDateTime outDate;
    private int capacity;
    private Long price;


}