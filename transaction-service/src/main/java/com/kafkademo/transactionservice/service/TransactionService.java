package com.kafkademo.transactionservice.service;

import com.kafkademo.transactionservice.config.configuration.producer.KafkaProducer;
import com.kafkademo.transactionservice.config.properties.TransactionCreatedTopicProperties;
import com.kafkademo.transactionservice.domain.model.Transaction;
import com.kafkademo.transactionservice.domain.model.UserWallet;
import com.kafkademo.transactionservice.domain.request.CreateTransactionRequest;
import com.kafkademo.transactionservice.domain.response.TransactionCreatedPayload;
import com.kafkademo.transactionservice.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;


@Service
@RequiredArgsConstructor
public class TransactionService {

    private final UserWalletService userWalletService;
    private final TransactionRepository transactionRepository;
    private final KafkaProducer kafkaProducer;
    private final TransactionCreatedTopicProperties transactionCreatedTopicProperties;

    @Transactional
    public void transferMoney(CreateTransactionRequest request){
        UserWallet sender= userWalletService.findByUserId(request.getSenderUserId());
        UserWallet receiver= userWalletService.findByUserId(request.getReceiverUserId());

        if(sender.getBalance().compareTo(request.getAmount())>0){
            sender.setBalance(sender.getBalance().subtract(request.getAmount()));
            receiver.setBalance(receiver.getBalance().add(request.getAmount()));
           Transaction transaction= transactionRepository.save(new Transaction(null,request.getSenderUserId(),request.getReceiverUserId(),request.getAmount()));
            TransactionCreatedPayload transactionCreatedPayload = TransactionCreatedPayload.getTransactionCreatedPayload(transaction);
            Map<String,Object> headers= new HashMap<>();
            headers.put(TOPIC,transactionCreatedTopicProperties.getTopicName());
            headers.put("partitionKey",transaction.getId());
            kafkaProducer.sendMessage(new GenericMessage<>(transactionCreatedPayload,headers));
            userWalletService.save(sender);
            userWalletService.save(receiver);
        }
    }

}
