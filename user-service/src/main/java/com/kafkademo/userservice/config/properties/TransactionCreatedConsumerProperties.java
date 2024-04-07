package com.kafkademo.userservice.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka.topics.transaction-created")
@Getter
@Setter
public class TransactionCreatedConsumerProperties {
 private String topic;
 private String consumerGroup;
}
