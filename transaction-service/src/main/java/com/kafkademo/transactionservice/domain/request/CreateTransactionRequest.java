package com.kafkademo.transactionservice.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateTransactionRequest {
    private Long senderUserId;
    private Long receiverUserId;
    private BigDecimal amount ;
}
