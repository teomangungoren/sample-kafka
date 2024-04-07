package com.kafkademo.transactionservice.domain.response;

import com.kafkademo.transactionservice.domain.model.Transaction;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class TransactionCreatedPayload{
    private Long id;
    private Long senderUserId;
    private Long receiverUserId;
    private BigDecimal amount;
    private Date createdAt;
    private Date updatedAt;

    public static TransactionCreatedPayload getTransactionCreatedPayload(Transaction transaction) {
        return TransactionCreatedPayload.builder()
                .id(transaction.getId())
                .senderUserId(transaction.getSenderUserId())
                .receiverUserId(transaction.getReceiverUserId())
                .amount(transaction.getAmount())
                .createdAt(transaction.getCreatedAt())
                .updatedAt(transaction.getUpdatedAt())
                .build();

    }
}
