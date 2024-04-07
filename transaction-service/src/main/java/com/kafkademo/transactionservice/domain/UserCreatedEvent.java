package com.kafkademo.transactionservice.domain;

import com.kafkademo.transactionservice.domain.model.UserWallet;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreatedEvent{

    private Long id;
    private String email;
    private BigDecimal balance;


    public static UserWallet getUserWallet(UserCreatedEvent userCreatedEvent) {
        return UserWallet.builder()
                .userId(userCreatedEvent.getId())
                .userEmail(userCreatedEvent.getEmail())
                .balance(userCreatedEvent.getBalance())
                .build();
    }
}
