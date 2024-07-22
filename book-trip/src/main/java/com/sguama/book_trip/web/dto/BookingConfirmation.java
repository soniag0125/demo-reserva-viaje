package com.sguama.book_trip.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class BookingConfirmation {

    private Long bookingId;
    private Long amount;
    private String mail;


}
