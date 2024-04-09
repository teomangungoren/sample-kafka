package com.kafkademo.notificationservice.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "kafka.topics.user-created")
public class UserCreatedTopicProperties {
    private String topic;
    private String consumerGroup;
}
