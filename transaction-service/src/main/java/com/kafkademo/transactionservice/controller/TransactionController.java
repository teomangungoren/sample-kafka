package com.kafkademo.transactionservice.controller;

import com.kafkademo.transactionservice.domain.model.Transaction;
import com.kafkademo.transactionservice.domain.request.CreateTransactionRequest;
import com.kafkademo.transactionservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> transfer(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }


}
