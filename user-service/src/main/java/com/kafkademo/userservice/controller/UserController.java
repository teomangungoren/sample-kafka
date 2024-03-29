package com.kafkademo.userservice.controller;

import com.kafkademo.userservice.domain.model.User;
import com.kafkademo.userservice.domain.request.RegisterRequest;
import com.kafkademo.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private RestTemplate restTemplate = new RestTemplate();
    private final UserService userService;

    @PostMapping
    public User registerUser(@RequestBody RegisterRequest request) {
        return userService.create(request);
    }

}
