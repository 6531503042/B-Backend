package com.example.b.service;

import com.example.b.dto.User;
import com.example.b.repositoryService.UserRepositoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class UserService {

    @Autowired
    private UserRepositoryService userRepositoryService;

    public List<User> getAllUser() {
        return userRepositoryService.getAll();
    }

    public ResponseEntity<?> createUser(User userToSave) {
        return userRepositoryService.createUser(userToSave);
    }

}
