package com.kafkademo.transactionservice.config;

import com.kafkademo.transactionservice.domain.UserCreatedEvent;
import com.kafkademo.transactionservice.domain.model.UserWallet;
import com.kafkademo.transactionservice.service.UserWalletService;
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
public class UserCreatedEventConsumer{

    private final UserWalletService userWalletService;

    @KafkaListener(topics = "${kafka.topics.user-created.topic}",
            groupId = "${kafka.topics.user-created.consumer-group}",
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void consumeCreatedUserEvent(@Payload UserCreatedEvent event,
                                        @Headers ConsumerRecord<String,Object> consumerRecord) {
        log.info("UserCreatedEventConsumer.consumeApprovalRequestResultedEvent consumed EVENT :{} " +
                        "from partition : {} " +
                        "with offset : {} " +
                        "thread : {} " +
                        "for message key: {}",
        event, consumerRecord.partition(), consumerRecord.offset(), Thread.currentThread().getName(), consumerRecord.key());
        UserWallet userWallet = UserCreatedEvent.getUserWallet(event);
        userWalletService.save(userWallet);
    }

}
