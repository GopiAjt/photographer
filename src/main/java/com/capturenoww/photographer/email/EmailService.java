package com.capturenoww.photographer.email;

import com.capturenoww.photographer.model.Customer;
import com.capturenoww.photographer.model.Photographer;
import com.capturenoww.photographer.repository.CustomerRepo;
import com.capturenoww.photographer.repository.PhotographerRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class EmailService {

    private final static Logger LOGGER = LoggerFactory
            .getLogger(EmailService.class);

    private final JavaMailSender mailSender;

    private final PhotographerRepo photographerRepo;

    private final CustomerRepo customerRepo;

    public static int otpGanaretor()
    {
        Random r = new Random();
        return r.nextInt(100000, 999999);
    }

    @Async
    public void sendToCustomer(String to, Customer c) {
    	
    	c.setSignupVerificationKey(otpGanaretor());
    	
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText("Hello, <br><br> Just one more step before you get started. <br><br> You must confirm your identity using the one-time pass code: <h1 style='color:blue;'>"+ c.getSignupVerificationKey() + "</h1><br><br>Sincerely,<br><br>CaptureNow", true);
            helper.setTo(to);
            helper.setSubject("Confirm your email id");
            helper.setFrom("capturenow.in@gmail.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }
    
    @Async
    public void sendToPhotographer(String to, Photographer p) {
    	
    	p.setSignupVerificationKey(otpGanaretor());
    	
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText("Hello, <br><br> Just one more step before you get started. <br><br> You must confirm your identity using the one-time pass code: <h1 style='color:blue;'>"+ p.getSignupVerificationKey() + "</h1><br><br>Sincerely,<br><br>CaptureNow", true);
            helper.setTo(to);
            helper.setSubject("Confirm your email id");
            helper.setFrom("capturenow.in@gmail.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }

    public void sendResetPasswordOtpToPhotographer(String to, Photographer photographer) {
        photographer.setResetPasswordVerificationKey(otpGanaretor());
        photographerRepo.save(photographer);
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText("Hello, <br><br> Just one more step to Reset you password. <br><br> You must confirm your identity using the one-time pass code: <h1 style='color:blue;'>"+ photographer.getResetPasswordVerificationKey() + "</h1><br><br>Sincerely,<br><br>CaptureNow.in", true);
            helper.setTo(to);
            helper.setSubject("OTP to Reset Password");
            helper.setFrom("capturenow.in@gmail.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }

    public void sendResetPasswordOtpToCustomer(String to, Customer customer) {
        customer.setResetPasswordVerificationKey(otpGanaretor());
        customerRepo.save(customer);
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText("Hello, <br><br> Just one more step to Reset you password. <br><br> You must confirm your identity using the one-time pass code: <h1 style='color:blue;'>"+ customer.getResetPasswordVerificationKey() + "</h1><br><br>Sincerely,<br><br>CaptureNow.in", true);
            helper.setTo(to);
            helper.setSubject("OTP to Reset Password");
            helper.setFrom("capturenow.in@gmail.com");
            mailSender.send(mimeMessage);
        }catch (MessagingException e) {
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }

    public void sendBookNotificationToPhotographer(String to, Photographer photographer){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(
                    "Knock! Knock!. <br><br>Hello, "+photographer.getName()+" <br><br> You have a Booking "+
                            "<br><br>Please go to you Dashboard to Accept the Booking<br><br>CaptureNow.in", true);
            helper.setTo(to);
            helper.setSubject("Alert! you got an order");
            helper.setFrom("capturenow.in@gmail.com");
            mailSender.send(mimeMessage);
        }catch (MessagingException e) {
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }

    public void sendBookingConfirmationToCustomer(String to, Customer customer){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(
                    "Knock! Knock!. <br><br>" +
                            "Hello, " +customer.getName()+
                            "<br><br> Your Booking has been confirmed by the photographer                                                                                                                        "+
                            "<br><br>Please go to you Dashboard to Pay and contact with the Photographer" +
                            "<br><br>CaptureNow.in", true);
            helper.setTo(to);
            helper.setSubject("Your Booking is confirmed!");
            helper.setFrom("capturenow.in@gmail.com");
            mailSender.send(mimeMessage);
        }catch (MessagingException e) {
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }
    public void sendBookingDeclineToCustomer(String to, Customer customer){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(
                    "Knock! Knock!. <br><br>" +
                            "Hello, " +customer.getName()+
                            "<br><br>we are sorry to inform you that                                                                                                                        "+
                            "<br><br>Your Booking has been Declined by the photographer" +
                            "<br><br>CaptureNow.in", true);
            helper.setTo(to);
            helper.setSubject("Your Booking is declined!");
            helper.setFrom("capturenow.in@gmail.com");
            mailSender.send(mimeMessage);
        }catch (MessagingException e) {
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }

}
