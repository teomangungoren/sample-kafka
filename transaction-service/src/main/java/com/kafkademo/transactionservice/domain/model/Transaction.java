package com.kafkademo.transactionservice.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "transactions")
@Entity
public class Transaction extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long senderUserId;
    private Long receiverUserId;
    private BigDecimal amount;


    public static Transaction getTransaction(Long senderUserId, Long receiverUserId, BigDecimal amount) {
        return Transaction.builder()
                .senderUserId(senderUserId)
                .receiverUserId(receiverUserId)
                .amount(amount)
                .build();
    }

}
