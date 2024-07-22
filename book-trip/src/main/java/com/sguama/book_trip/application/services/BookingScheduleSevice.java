package com.sguama.book_trip.application.services;

import com.sguama.book_trip.application.interfaces.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class BookingScheduleSevice {

    @Autowired
    INotificationService notificationService;

    public BookingScheduleSevice(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(cron = "0 * * * * MON-SUN")
    public void generateReminderFlights() {
        notificationService.sendEmail("soniag0125@hotmail.com",
                "Recordatorio de vuelos",
                "Recuerde no perder su vuelo el día de mañana.");
    }
}
