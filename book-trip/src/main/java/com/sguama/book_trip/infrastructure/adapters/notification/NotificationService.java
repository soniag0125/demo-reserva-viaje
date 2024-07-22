package com.sguama.book_trip.infrastructure.adapters.notification;

import com.sguama.book_trip.application.interfaces.INotificationService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService {

    private final JavaMailSender mailSender;

    private NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    @Async
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("notificacionesSGM@outlook.com");
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}
