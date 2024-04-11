package com.kafkademo.transactionservice.repository;

import com.kafkademo.transactionservice.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findById(Long id);

}
