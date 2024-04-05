package com.kafkademo.transactionservice.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka.topics.user-created")
public class UserCreatedConsumerProperties {
    private String topic;
    private String consumerGroup;
}
