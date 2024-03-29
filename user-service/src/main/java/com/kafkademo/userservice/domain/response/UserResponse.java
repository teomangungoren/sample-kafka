package com.kafkademo.userservice.domain.response;

import com.kafkademo.userservice.domain.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Getter
@Setter
@Builder
public class UserResponse {
    private String name;
    private String surname;
    private String email;
    private BigDecimal balance;
    private Date createdAt;
    private Date updatedAt;

    public static UserResponse getUserResponse(User user) {
        UserResponse response= UserResponse.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .balance(user.getBalance())
                .build();
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());
        return response;
    }
}
