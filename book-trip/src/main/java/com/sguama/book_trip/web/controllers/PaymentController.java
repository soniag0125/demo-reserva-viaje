package com.sguama.book_trip.web.controllers;

import com.sguama.book_trip.application.services.PaymentConfirmationService;
import com.sguama.book_trip.domain.usecases.UpdateBookingService;
import com.sguama.book_trip.infrastructure.entity.PaymentEntity;
import com.sguama.book_trip.web.dto.BookingConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    private PaymentConfirmationService paymentConfirmationService;

    @Autowired
    private UpdateBookingService updateBookingService;

    @PostMapping("/booking/v1")
    public ResponseEntity<PaymentEntity> processPayment(
            @RequestBody BookingConfirmation bookingConfirmation) {
        PaymentEntity payment =
                paymentConfirmationService.processPayment(
                        bookingConfirmation.getAmount(), bookingConfirmation.getBookingId(),
                        bookingConfirmation.getMail());
        updateBookingService.confirmedBooking(bookingConfirmation.getBookingId());
        return ResponseEntity.ok(payment);
    }
}
