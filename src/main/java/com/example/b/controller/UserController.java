package com.example.b.controller;

import com.example.b.dto.User;
import com.example.b.exchanges.BaseResponse;
import com.example.b.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class UserController  {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public BaseResponse<?> create(@Valid @RequestBody User newUser) {
        log.info("user create method called {}", newUser);
        ResponseEntity<?> responseEntity = userService.createUser(newUser);
        if (responseEntity.getStatusCodeValue() == 400) {
            return new BaseResponse<>(null, "Already Exist");
        } else {
            return new BaseResponse<>((User) responseEntity.getBody(), responseEntity.getStatusCode().toString());
        }

    }
}
