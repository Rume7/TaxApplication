package com.example.utility;


import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author E238958
 * Send Email using SSL Authentication.
 */
public class EmailUtil {
    
    private String subject;
    private String messageBody;

    public EmailUtil() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
    
    public void sendEmail(String senderEmail, String senderPassword, String recipientEmail ) throws UnsupportedEncodingException {

        System.out.println("SSL Email Start");
        
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");     // SMTP Host
        properties.put("mail.smtp.socketFactory.port", "465");  // SSL Port
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  // SSL Factory
        
        properties.put("mail.smtp.auth", "true");               // Enabling SMTP Authentication
        properties.put("mail.smtp.port", "465");                // SMTP Port
        
        Authenticator auth = new Authenticator() {

            // override the getPasswordAuthentication method
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        }; 
        
        Session session = Session.getDefaultInstance(properties, auth);
        System.out.println("Session created");
        
        prepareEmail(session, recipientEmail, this.getSubject(), this.getMessageBody());
        
    }
    
    private void prepareEmail(Session session, String toEmail, String subject, String body) throws UnsupportedEncodingException {
        try {
            
            MimeMessage msg = new MimeMessage(session);
            
            // Set message headers
            msg.addHeader("Content-type", "text/html; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            
            msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));      
            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            
            System.out.println("Message is ready");
            Transport.send(msg);
            System.out.println("Email sent successfully!!");
            
        } catch(MessagingException e) {
            e.getMessage();
        }
    }    
}
