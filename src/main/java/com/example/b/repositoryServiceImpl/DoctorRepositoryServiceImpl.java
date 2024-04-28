package com.example.b.repositoryServiceImpl;

import com.example.b.dto.Doctor;
import com.example.b.dto.Status;
import com.example.b.repository.DoctorRepository;
import com.example.b.repositoryService.DoctorRepositoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class DoctorRepositoryServiceImpl implements DoctorRepositoryService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public ResponseEntity<?> createDoctor(Doctor doctorToSave) {
        if(isDoctorExist(doctorToSave)) {
            return ResponseEntity.badRequest().body("Doctor with the same info is already exist");
        } else {
            doctorToSave.setStatus(Status.ACTIVE);
            doctorRepository.save(doctorToSave);
            return ResponseEntity.ok(doctorToSave);
        }
    }

    @Override
    public ResponseEntity<?> getAllDoctor() {

        List<Doctor> doctorList = (List<Doctor>) doctorRepository.findAll();
        return ResponseEntity.ok(doctorList);
    }

    private boolean isDoctorExist(Doctor doctorToSave) {
        List<Doctor> savedDoctorList = (List<Doctor>) doctorRepository.findAll();
        for (Doctor d : savedDoctorList) {
            if (d.getPhoneNumber() != null && d.getPhoneNumber().equals(doctorToSave.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }
}
