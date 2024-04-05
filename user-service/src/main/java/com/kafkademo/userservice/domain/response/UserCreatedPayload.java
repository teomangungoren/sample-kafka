package com.kafkademo.userservice.domain.response;

import com.kafkademo.userservice.domain.model.User;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class UserCreatedPayload {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private BigDecimal balance;
    private Date createdAt;
    private Date updatedAt;

    public static UserCreatedPayload getUserCreatedPayload(User user) {
        return UserCreatedPayload.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .balance(user.getBalance())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
