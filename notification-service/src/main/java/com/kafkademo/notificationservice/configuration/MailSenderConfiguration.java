package com.kafkademo.notificationservice.configuration;

import com.kafkademo.notificationservice.configuration.properties.MailSenderProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class MailSenderConfiguration{

    private final MailSenderProperties mailSenderProperties;

    @Bean
       JavaMailSender javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailSenderProperties.getHost());
        mailSender.setPort(mailSenderProperties.getPort());
        mailSender.setUsername(mailSenderProperties.getUsername());
        mailSender.setPassword(mailSenderProperties.getPassword());
        configureMailProperties(mailSender.getJavaMailProperties());
        return mailSender;
    }

    public void configureMailProperties(Properties properties){
        properties.put("mail.smtp.auth", mailSenderProperties.getAuth());
        properties.put("mail.smtp.starttls.enable", mailSenderProperties.getStarttlsEnable());
    }
}
