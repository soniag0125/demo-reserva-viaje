package com.sguama.book_trip.application.interfaces;

import com.sguama.book_trip.infrastructure.entities.PaymentEntity;

public interface IPaymentRepository {

    void save(PaymentEntity payment);
}
