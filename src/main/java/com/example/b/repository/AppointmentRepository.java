package com.example.b.repository;

import com.example.b.dto.Appointment;
import com.example.b.dto.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, String> {
    List<Appointment> findAllBySlotIdAndDoctorIdAndUserIdAndSTATUS(String slotId, String doctorId, String userId, Status status);
}
