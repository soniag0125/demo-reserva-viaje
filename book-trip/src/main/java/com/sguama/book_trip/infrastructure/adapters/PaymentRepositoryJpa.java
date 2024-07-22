package com.sguama.book_trip.infrastructure.adapters;

import com.sguama.book_trip.application.interfaces.IPaymentRepository;
import com.sguama.book_trip.infrastructure.entity.PaymentEntity;
import com.sguama.book_trip.infrastructure.respositories.PaymentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class PaymentRepositoryJpa implements IPaymentRepository {

    @Autowired
    private PaymentJpaRepository paymentJpaRepository;

    @Override
    public void save(PaymentEntity payment) {
        paymentJpaRepository.save(payment);
    }
}
