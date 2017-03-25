/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author guru
 */
public class EmailHandler {

    public static void sendEmail(String email, String verificationcode) {
        try {
            String host = "smtp.gmail.com";
            String user = "developer2046@gmail.com";
            String fromEmail = "developer2046@gmail.com"; //parametrize this to read from xml or database file
            String toEmail = email;
            String password = "357b95b11518c501c72f9682e2cd969c6f0e24531107d988285576b23ba2b316";//parameterize this to read from xml or database file
            String subject = "UCO CS Advisement: Successful Registration";
            String message = "Dear User, <br/> Thankyou for registering to CS Advisement System. Please login to the system using the verification code: <br/><b>"+verificationcode+"</b>.<br/> Regards,<br/> CS Advisement team";
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "true");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(fromEmail));
            InternetAddress[] address = {new InternetAddress(toEmail)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setContent(message, "text/html; charset=utf-8");
            msg.setSentDate(new Date());
            
            Transport transport = mailSession.getTransport("smtp");
            transport.addTransportListener(new TransportListener() {
                @Override
                public void messageDelivered(TransportEvent te) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void messageNotDelivered(TransportEvent te) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void messagePartiallyDelivered(TransportEvent te) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            
            transport.connect(host, user, password);
            transport.sendMessage(msg, address);
            transport.close();
        } catch (MessagingException ex) {
            System.out.println("Could not send email " + ex);
        }
    }

}
