package com.example.b.repositoryService;

import com.example.b.dto.Doctor;
import org.springframework.http.ResponseEntity;

public interface DoctorRepositoryService {
    ResponseEntity<?> createDoctor(Doctor doctorToSave);

    ResponseEntity<?> getAllDoctor();
}
