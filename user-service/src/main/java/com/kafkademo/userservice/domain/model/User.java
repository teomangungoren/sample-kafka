package com.kafkademo.userservice.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private BigDecimal balance;

    public static User getUser(String name, String surname, String email, BigDecimal balance) {
        return User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .balance(balance)
                .build();
    }
}
