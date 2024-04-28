package com.example.b.repositoryService;


import com.example.b.dto.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserRepositoryService {
    ResponseEntity<?> createUser(User userToSave);

    List<User> getAll();
}
