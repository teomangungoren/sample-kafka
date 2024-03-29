package com.kafkademo.userservice.service;

import com.kafkademo.userservice.domain.model.User;
import com.kafkademo.userservice.domain.request.RegisterRequest;
import com.kafkademo.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(RegisterRequest request) {
        User user = User.getUser(request.getName(), request.getSurname(), request.getEmail(), request.getBalance());
        return userRepository.save(user);
    }
}
