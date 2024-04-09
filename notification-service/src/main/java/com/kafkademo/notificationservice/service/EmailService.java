package com.kafkademo.notificationservice.service;

import com.kafkademo.notificationservice.domain.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
  private final JavaMailSender javaMailSender;

  public void sendEmail(UserCreatedEvent event){
      SimpleMailMessage mailMessage = new SimpleMailMessage();
      mailMessage.setTo(event.getEmail());
      mailMessage.setSubject("Creation Successful");
      mailMessage.setText("Dear: " + event.getEmail() + "\n" +
              "Your account was created successfully. Thank you for using our service.");
        javaMailSender.send(mailMessage);
  }
}
