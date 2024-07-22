package com.sguama.book_trip.application.interfaces;

public interface INotificationService {

    void sendEmail(String to, String subject, String body);
}
