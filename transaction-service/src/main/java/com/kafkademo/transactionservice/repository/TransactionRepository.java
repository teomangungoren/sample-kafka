package com.kafkademo.transactionservice.repository;

import com.kafkademo.transactionservice.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
