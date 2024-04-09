package com.kafkademo.notificationservice.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "mail.sender")
@Configuration
@Getter
@Setter
public class MailSenderProperties {
    private String host;
    private int port;
    private String username;
    private String password;
    private Boolean auth;
    private Boolean starttlsEnable;
}
