package com.kafkademo.userservice.repository;

import com.kafkademo.userservice.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
