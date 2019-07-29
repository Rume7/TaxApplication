package com.example.email_tin_services.controller;

import com.example.email_tin_services.model.Credentials;
import java.util.Calendar;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author E238958
 *
 */
public class EmailService {

    private static final long serialVersionUID = 1L;

    @Resource(lookup = "EmailMe")
    Session session;

    @Inject
    Credentials creds;

    private final String bodyOfEmail;
    private final String subject;

    public EmailService(String subject, String body) {
        this.bodyOfEmail = body;
        this.subject = subject;
    }

    public void sendEmail() {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(creds.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(creds.getTo()));
            message.setSubject(subject + Calendar.getInstance().getTime());
            message.setText(bodyOfEmail);

            Transport t = session.getTransport();
            t.connect(creds.getFrom(), creds.getPassword());
            t.sendMessage(message, message.getAllRecipients());

            //println("Mail sent... kindly check your email for confirmation!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
