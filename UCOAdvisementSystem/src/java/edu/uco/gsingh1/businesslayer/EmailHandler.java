/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
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

    public static void sendVerificationCodeEmail(String email, String verificationcode) throws UnsupportedEncodingException {
        System.out.println("verification code email sent");
//        try {
//            String host = "smtp.gmail.com";
//            String user = ResourceBundle.getBundle("/edu/uco/gsingh1/emailconfig").getString("emailsender");
//            String fromEmail = ResourceBundle.getBundle("/edu/uco/gsingh1/emailconfig").getString("emailsender");
//            String toEmail = email;
//            String password = ResourceBundle.getBundle("/edu/uco/gsingh1/emailconfig").getString("emailpassword");
//            String subject = "Successful Registration";
//            String message = "Dear User, <br/> Thankyou for registering to CS Advisement System. Please login to the system using the verification code: <br/><b>" + verificationcode + "</b>.<br/> Regards,<br/> CS Advisement team";
//            Properties props = System.getProperties();
//            props.put("mail.smtp.starttls.enable", "true");
//            props.put("mail.smtp.host", "true");
//            props.put("mail.smtp.port", "587");
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.starttls.required", "true");
//
//            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//
//            Session mailSession = Session.getDefaultInstance(props, null);
//            mailSession.setDebug(true);
//            Message msg = new MimeMessage(mailSession);
//            msg.setFrom(new InternetAddress(fromEmail, "UCO CS Advisement"));
//            InternetAddress[] address = {new InternetAddress(toEmail)};
//            msg.setRecipients(Message.RecipientType.TO, address);
//            msg.setSubject(subject);
//            msg.setContent(message, "text/html; charset=utf-8");
//            msg.setSentDate(new Date());
//
//            Transport transport = mailSession.getTransport("smtp");
//            transport.addTransportListener(new TransportListener() {
//                @Override
//                public void messageDelivered(TransportEvent te) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public void messageNotDelivered(TransportEvent te) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public void messagePartiallyDelivered(TransportEvent te) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//            });
//
//            transport.connect(host, user, password);
//            transport.sendMessage(msg, address);
//            transport.close();
//        } catch (MessagingException ex) {
//            System.out.println("Could not send email " + ex);
//        }
    }

    public static void sendAppointmentConfirmation(String email, String AppointmentDate, String AppointmentFromTime, String AppointmentToTime) throws UnsupportedEncodingException {
        System.out.println("appointment confirmation email sent");
//        try {
//            String host = "smtp.gmail.com";
//            String user = ResourceBundle.getBundle("/edu/uco/gsingh1/emailconfig").getString("emailsender");
//            String fromEmail = ResourceBundle.getBundle("/edu/uco/gsingh1/emailconfig").getString("emailsender");
//            String toEmail = email;
//            String password = ResourceBundle.getBundle("/edu/uco/gsingh1/emailconfig").getString("emailpassword");
//            String subject = "Booking Confirmed";
//            String message = "Dear User, <br/>Your appointment has been scheduled for <br/><b>Date: " + AppointmentDate
//                    + "</b><br/><b>From Time: " + AppointmentFromTime
//                    + "</b><br/><b>To Time: " + AppointmentToTime
//                    + "</b><br/>Regards,<br/> CS Advisement team";
//            Properties props = System.getProperties();
//            props.put("mail.smtp.starttls.enable", "true");
//            props.put("mail.smtp.host", "true");
//            props.put("mail.smtp.port", "587");
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.starttls.required", "true");
//
//            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//
//            Session mailSession = Session.getDefaultInstance(props, null);
//            mailSession.setDebug(true);
//            Message msg = new MimeMessage(mailSession);
//            msg.setFrom(new InternetAddress(fromEmail, "UCO CS Advisement"));
//            InternetAddress[] address = {new InternetAddress(toEmail)};
//            msg.setRecipients(Message.RecipientType.TO, address);
//            msg.setSubject(subject);
//            msg.setContent(message, "text/html; charset=utf-8");
//            msg.setSentDate(new Date());
//
//            Transport transport = mailSession.getTransport("smtp");
//            transport.addTransportListener(new TransportListener() {
//                @Override
//                public void messageDelivered(TransportEvent te) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public void messageNotDelivered(TransportEvent te) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public void messagePartiallyDelivered(TransportEvent te) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//            });
//
//            transport.connect(host, user, password);
//            transport.sendMessage(msg, address);
//            transport.close();
//        } catch (MessagingException ex) {
//            System.out.println("Could not send email " + ex);
//        }
    }

    public static void sendAppointmentCancellation(String email, String AppointmentDate, String AppointmentFromTime, String AppointmentToTime) throws UnsupportedEncodingException {
          System.out.println("appointment cancel email sent");
//        try {
//            String host = "smtp.gmail.com";
//            String user = ResourceBundle.getBundle("/edu/uco/gsingh1/emailconfig").getString("emailsender");
//            String fromEmail = ResourceBundle.getBundle("/edu/uco/gsingh1/emailconfig").getString("emailsender");
//            String toEmail = email;
//            String password = ResourceBundle.getBundle("/edu/uco/gsingh1/emailconfig").getString("emailpassword");
//            String subject = "Appointment Cancelled";
//            String message = "Dear User, <br/>Your appointment scheduled has been cancelled for the booking below: <br/><b>Date: " + AppointmentDate
//                    + "</b><br/><b>From Time: " + AppointmentFromTime
//                    + "</b><br/><b>To Time: " + AppointmentToTime
//                    + "</b><br/>Please login to the advisement system and choose a different date and time of booking<br/>.Regards,<br/> CS Advisement team";
//            Properties props = System.getProperties();
//            props.put("mail.smtp.starttls.enable", "true");
//            props.put("mail.smtp.host", "true");
//            props.put("mail.smtp.port", "587");
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.starttls.required", "true");
//
//            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//
//            Session mailSession = Session.getDefaultInstance(props, null);
//            mailSession.setDebug(true);
//            Message msg = new MimeMessage(mailSession);
//            msg.setFrom(new InternetAddress(fromEmail, "UCO CS Advisement"));
//            InternetAddress[] address = {new InternetAddress(toEmail)};
//            msg.setRecipients(Message.RecipientType.TO, address);
//            msg.setSubject(subject);
//            msg.setContent(message, "text/html; charset=utf-8");
//            msg.setSentDate(new Date());
//
//            Transport transport = mailSession.getTransport("smtp");
//            transport.addTransportListener(new TransportListener() {
//                @Override
//                public void messageDelivered(TransportEvent te) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public void messageNotDelivered(TransportEvent te) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public void messagePartiallyDelivered(TransportEvent te) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//            });
//
//            transport.connect(host, user, password);
//            transport.sendMessage(msg, address);
//            transport.close();
//        } catch (MessagingException ex) {
//            System.out.println("Could not send email " + ex);
//        }
    }
}
