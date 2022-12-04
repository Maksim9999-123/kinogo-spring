package com.example.kinogospring.service;

import javax.mail.MessagingException;

public interface MailService {

    void sendHtmlEmail(String to, String subject, String text) throws MessagingException;
}
