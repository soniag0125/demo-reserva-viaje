package com.sguama.book_trip.infrastructure.respositories;

import com.sguama.book_trip.infrastructure.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, Long> {
}
