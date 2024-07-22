package com.sguama.book_trip.application.interfaces;

import com.sguama.book_trip.infrastructure.entity.NotificationEntity;
import com.sguama.book_trip.infrastructure.entity.PaymentEntity;

public interface INotificationRepository {

    void save(NotificationEntity notificationEntity);
}
