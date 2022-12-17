package com.itspace.kinogospringcommon.service.impl;


import com.itspace.kinogospringcommon.exception.SendEmailFailed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static com.itspace.kinogospringcommon.exception.ErrorHandler.SEND_EMAIL_FAILED;


/**
 * {@link MailServiceImpl} send mail user for verify.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class MailServiceImpl {

    private final JavaMailSender mailSender;

    @Async
    public void sendHtmlEmail(String to, String subject, String text) {
        log.debug("Send e-mail[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}", to, subject);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            log.debug("Sent e-mail to User '{}'", to);
        } catch (MessagingException e) {
            new SendEmailFailed(SEND_EMAIL_FAILED);
            log.warn("E-mail could not be sent to user '{}'", to, e);
        }

        mailSender.send(mimeMessage);

    }
}
