package com.kafkademo.notificationservice.configuration;

import com.kafkademo.notificationservice.domain.UserCreatedEvent;
import com.kafkademo.notificationservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserCreatedEventConsumer {

    private final EmailService emailService;

    @KafkaListener(topics = "${kafka.topics.user-created.topic}",
            groupId = "${kafka.topics.user-created.consumer-group}",
            containerFactory ="concurrentKafkaListenerContainerFactory")
    public void consumeCreateTransactionEvent(@Payload UserCreatedEvent event,
                                              @Headers ConsumerRecord<String,Object> consumerRecord) {
        log.info("UserCreatedEventConsumer.consumeApprovalRequestResultedEvent consumed EVENT :{} " +
                        "from partition : {} " +
                        "with offset : {} " +
                        "thread : {} " +
                        "for message key: {}",
                event, consumerRecord.partition(), consumerRecord.offset(), Thread.currentThread().getName(), consumerRecord.key());
        UserCreatedEvent.createMailToUser(event,emailService);
    }
}
