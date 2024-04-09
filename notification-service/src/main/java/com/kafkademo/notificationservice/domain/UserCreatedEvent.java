package com.kafkademo.notificationservice.domain;

import com.kafkademo.notificationservice.service.EmailService;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreatedEvent {
    private String email;

    public static void createMailToUser(UserCreatedEvent event, EmailService emailService){
        emailService.sendEmail(event);
    }
}
