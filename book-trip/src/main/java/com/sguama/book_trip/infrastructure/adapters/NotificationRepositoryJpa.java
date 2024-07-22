package com.sguama.book_trip.infrastructure.adapters;

import com.sguama.book_trip.application.interfaces.INotificationRepository;
import com.sguama.book_trip.infrastructure.entity.NotificationEntity;
import com.sguama.book_trip.infrastructure.respositories.NotificationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationRepositoryJpa implements INotificationRepository {

    @Autowired
    private NotificationJpaRepository notificationJpaRepository;

    @Override
    public void save(NotificationEntity notificationEntity) {

        notificationJpaRepository.save(notificationEntity);
    }
}
