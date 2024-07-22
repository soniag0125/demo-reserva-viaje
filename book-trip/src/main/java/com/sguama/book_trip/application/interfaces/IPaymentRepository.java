package com.sguama.book_trip.application.interfaces;

import com.sguama.book_trip.infrastructure.entity.PaymentEntity;

public interface IPaymentRepository {

    void save(PaymentEntity payment);
}
