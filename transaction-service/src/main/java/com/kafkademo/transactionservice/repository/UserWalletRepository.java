package com.kafkademo.transactionservice.repository;

import com.kafkademo.transactionservice.domain.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWallet, Long> {
}
