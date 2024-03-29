package com.kafkademo.userservice.domain.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RegisterRequest {
    private String name;
    private String surname;
    private String email;
    private BigDecimal balance;
}
