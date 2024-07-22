package com.sguama.book_trip.infrastructure.respositories;

import com.sguama.book_trip.infrastructure.entity.NotificationEntity;
import com.sguama.book_trip.infrastructure.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationJpaRepository extends JpaRepository<NotificationEntity, Long> {
}
