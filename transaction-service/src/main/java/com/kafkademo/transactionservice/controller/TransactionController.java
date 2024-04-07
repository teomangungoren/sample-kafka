package com.kafkademo.transactionservice.controller;

import com.kafkademo.transactionservice.domain.request.CreateTransactionRequest;
import com.kafkademo.transactionservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {
      private final TransactionService transactionService;
    @PostMapping
    public ResponseEntity<String> transfer(@RequestBody CreateTransactionRequest request) {
        transactionService.transferMoney(request);
        return ResponseEntity.ok("Successfully transaction completed");
    }


}
