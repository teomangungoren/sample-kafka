package com.kafkademo.transactionservice.service;

import com.kafkademo.transactionservice.domain.UserWallet;
import com.kafkademo.transactionservice.repository.UserWalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserWalletService {

    private final UserWalletRepository userWalletRepository;

    public UserWallet save(UserWallet userWallet) {
        return userWalletRepository.save(userWallet);
    }
}
