package com.kafkademo.transactionservice.domain;

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
    private BigDecimal balance;

    public static UserWallet getUserWallet(UserCreatedEvent userCreatedEvent) {
        return UserWallet.builder()
                .userId(userCreatedEvent.getId())
                .balance(userCreatedEvent.getBalance())
                .build();
    }
}
