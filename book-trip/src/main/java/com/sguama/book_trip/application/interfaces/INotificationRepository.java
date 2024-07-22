package com.sguama.book_trip.application.interfaces;

import com.sguama.book_trip.infrastructure.entities.NotificationEntity;

public interface INotificationRepository {

    void save(NotificationEntity notificationEntity);
}
