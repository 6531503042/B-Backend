package com.example.b.repositoryServiceImpl;

import com.example.b.dto.Status;
import com.example.b.dto.User;
import com.example.b.repository.UserRepository;
import com.example.b.repositoryService.UserRepositoryService;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService {

    @Autowired
    private UserRepository userRepository;

    private Provider<ModelMapper> modelMapperProvider;

    @Override
    public ResponseEntity<?> createUser(User userToSave) {
        if (isUserAlreadyExist(userToSave)) {
            return ResponseEntity.badRequest().body("User with the same info is already exist");
        } else {
            userToSave.setStatus(Status.ACTIVE);
            userRepository.save(userToSave);
            return ResponseEntity.ok(userToSave);
        }
    }

    private boolean isUserAlreadyExist(User userToSave) {
        List<User> savedUserList = (List<User>) userRepository.findAll();
        for (User u : savedUserList) {
            if (u.getEmail() != null && u.getEmail().equals(userToSave.getEmail())
                && u.getStatus() == Status.ACTIVE)
                return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(user -> user.getStatus() == Status.ACTIVE)
                .collect(Collectors.toList());
    }




}
