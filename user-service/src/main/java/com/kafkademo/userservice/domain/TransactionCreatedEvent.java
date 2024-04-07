package com.kafkademo.userservice.domain;

import com.kafkademo.userservice.service.UserService;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionCreatedEvent{

    private Long senderUserId;
    private Long receiverUserId;
    private BigDecimal amount;

    public static void getUser(TransactionCreatedEvent transactionCreatedEvent, UserService userService){
        userService.updateBalance(transactionCreatedEvent);
    }

}
