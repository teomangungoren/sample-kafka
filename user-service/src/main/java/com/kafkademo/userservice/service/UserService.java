package com.kafkademo.userservice.service;

import com.kafkademo.userservice.config.producer.KafkaProducer;
import com.kafkademo.userservice.config.properties.UserCreatedTopicProperties;
import com.kafkademo.userservice.domain.model.User;
import com.kafkademo.userservice.domain.request.RegisterRequest;
import com.kafkademo.userservice.domain.response.UserCreatedPayload;
import com.kafkademo.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final KafkaProducer kafkaProducer;
    private final UserCreatedTopicProperties userCreatedTopicProperties;

    public User create(RegisterRequest request) {
        User user = User.getUser(request.getName(), request.getSurname(), request.getEmail(), request.getBalance());
        User savedUser = userRepository.save(user);
        UserCreatedPayload userCreatedPayload = UserCreatedPayload.getUserCreatedPayload(savedUser);
        Map<String,Object> headers = new HashMap<>();
        headers.put(TOPIC,userCreatedTopicProperties.getTopicName());
        headers.put("partitionKey",savedUser.getId());
        kafkaProducer.sendMessage(new GenericMessage<>(userCreatedPayload,headers));
        return savedUser;
    }
}
