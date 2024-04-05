package com.kafkademo.userservice.config.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public void sendMessage(GenericMessage message){
        CompletableFuture<? extends SendResult<String,?>> future = kafkaTemplate.send(message);

       future.whenComplete((result, ex) -> {
            if (Objects.nonNull(ex)) {
                log.error("Error while sending message to kafka", ex);
            } else {
                log.info("Message sent to kafka");
                log.info("Message :{} published, topic : {}, partition : {} and offset : {}", message.getPayload(),
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset());
            }
        });
    }
    
}
