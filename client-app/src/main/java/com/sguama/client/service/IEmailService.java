package com.sguama.client.service;


public interface IEmailService {

    void sendEmail(String to, String subject, String body);
}
