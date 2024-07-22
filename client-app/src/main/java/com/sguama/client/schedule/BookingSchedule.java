package com.sguama.client.schedule;

import com.sguama.client.service.EmailService;
import com.sguama.client.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BookingSchedule {

    @Autowired
    IEmailService mail;

    public BookingSchedule(IEmailService mail) {
        this.mail = mail;
    }

    @Scheduled(cron = "0 * * * * MON-SUN")
    public void generateReminderFlights() {
        mail.sendEmail("r_d58@hotmail.com", "Notificaciones Test", "No respoder este mensaje");
    }
}
