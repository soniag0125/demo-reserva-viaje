package com.sguama.book_trip.application.services;

import com.sguama.book_trip.application.interfaces.IBookingRepository;
import com.sguama.book_trip.application.interfaces.IFlightRepository;
import com.sguama.book_trip.application.interfaces.INotificationRepository;
import com.sguama.book_trip.application.interfaces.IPaymentRepository;
import com.sguama.book_trip.application.util.ResourceNotFoundException;
import com.sguama.book_trip.domain.model.Booking;
import com.sguama.book_trip.domain.model.Flight;
import com.sguama.book_trip.infrastructure.entity.BookingEntity;
import com.sguama.book_trip.infrastructure.entity.NotificationEntity;
import com.sguama.book_trip.infrastructure.entity.PaymentEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.sguama.book_trip.application.util.Constants.SUCCESS;
import static com.sguama.book_trip.domain.common.Constants.ACTIVE_BOOKING;

@Component
public class PaymentConfirmationService {

    private final IPaymentRepository repositoryPayment;
    private final IBookingRepository repositoryBookings;
    private final IFlightRepository repositoryFlights;
    private final INotificationRepository notificationRepository;

    public PaymentConfirmationService(IPaymentRepository repositoryPayment, IBookingRepository repositoryBookings, IFlightRepository repositoryFlights, INotificationRepository notificationRepository) {
        this.repositoryPayment = repositoryPayment;
        this.repositoryBookings = repositoryBookings;
        this.repositoryFlights = repositoryFlights;
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    public PaymentEntity processPayment(Long amount, Long bookingId, String mail) {
        Booking booking = repositoryBookings.getBookingById(bookingId);
        if (booking.getStatus().equals(ACTIVE_BOOKING)) {
            Flight flight = repositoryFlights.getFlightById(booking.getFlightId());
            if (flight.getPrice().equals(amount)){
                PaymentEntity payment = PaymentEntity.builder()
                        .amount(amount)
                        .bookingId(bookingId)
                        .paymentDate(LocalDateTime.now())
                        .status(SUCCESS)
                        .build();
                repositoryPayment.save(payment);
                saveNotificationConfirmed(bookingId, mail);
                return payment;
            } else {
                throw new ResourceNotFoundException("Is not a correct payment");
            }
        } else {
            throw new ResourceNotFoundException("Booking is not active");
        }
    }

    private void saveNotificationConfirmed(Long bookingId, String mail) {
        NotificationEntity notificationEntity =
                NotificationEntity.builder()
                        .bookingEntity(BookingEntity.builder()
                                .id(bookingId)
                                .build())
                        .mail(mail)
                        .build();
        notificationRepository.save(notificationEntity);
    }
}
