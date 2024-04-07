package com.kafkademo.userservice.config;

import com.kafkademo.userservice.domain.TransactionCreatedEvent;
import com.kafkademo.userservice.service.UserService;
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
public class TransactionCreatedEventConsumer{

    private final UserService userService;

    @KafkaListener(topics = "${kafka.topics.transaction-created.topic}",
                  groupId = "${kafka.topics.transaction-created.consumer-group}",
                  containerFactory ="concurrentKafkaListenerContainerFactory")
     public void consumeCreatedTransactionEvent(@Payload TransactionCreatedEvent event,
                                                @Headers ConsumerRecord<String,Object> consumerRecord){
        log.info("UserCreatedEventConsumer.consumeApprovalRequestResultedEvent consumed EVENT :{} " +
                        "from partition : {} " +
                        "with offset : {} " +
                        "thread : {} " +
                        "for message key: {}",
                event, consumerRecord.partition(), consumerRecord.offset(), Thread.currentThread().getName(), consumerRecord.key());
         TransactionCreatedEvent.getUser(event,userService);
    }

}
