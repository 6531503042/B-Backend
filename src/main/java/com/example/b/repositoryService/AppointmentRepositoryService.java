//package com.example.b.repositoryService;
//
//import com.example.b.dto.Appointment;
//import com.example.b.dto.Doctor;
//import com.example.b.dto.Slot;
//import com.example.b.dto.Status;
//import com.example.b.exchanges.SlotBookingRequest;
//import com.example.b.repository.AppointmentRepository;
//import com.example.b.repository.DoctorRepository;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AppointmentRepositoryService {
//
//    @Autowired
//    private AppointmentRepository appointmentRepository;
//
//    public Appointment createAppointment(SlotBookingRequest slotRequest) {
//        Appointment appointment = Appointment.builder()
//                .appointmentDate(slotRequest.getBookingDate())
//                .doctorId(slotRequest.getDoctorId())
//                .userId(slotRequest.getUserId())
//                .slotId(slotRequest.getSlotId())
//                .STATUS(Status.ACTIVE).build();
//
//        appointmentRepository.save(appointment);
//
//        return null;
//    }
//
//    public List<Appointment> findAppointmentBySlot(Slot currentSlot, String userId) {
//        return appointmentRepository.findAllBySlotIdAndDoctorIdAndUserIdAndSTATUS(
//                currentSlot.id,
//                currentSlot.getDoctorId(), userId,
//                Status.ACTIVE);
//    }
//
//    /**
//     * Find booked appointments based on the current slot.
//     *
//     * @param currentSlot the slot to search appointments for
//     * @return a list of booked appointments for the given slot
//     */
//    public List<Appointment> findBookedAppointment(Slot currentSlot) {
//        // Find appointments in the repository by slot ID, doctor ID, and status
//        return appointmentRepository.findAllBySlotIdAndDoctorIdAndSTATUS(
//                currentSlot.id,
//                currentSlot.getDoctorId(),
//                Status.ACTIVE);
//    }
//
//    /**
//     * Check if there is an existing appointment for the given slot on the requested date.
//     *
//     * @param slotRequest the slot booking request containing slotId, doctorId, and userId
//     * @param epochRequestedDate the requested date in epoch format
//     * @return true if an appointment already exists for the requested date, false otherwise
//     */
//    public boolean alreadyExist(SlotBookingRequest slotRequest, Long epochRequestedDate) {
//        // Find all active appointments for the given slot, doctor, and user
//        List<Appointment> appointmentList = appointmentRepository
//                .findAllBySlotIdAndDoctorIdAndUserIdAndSTATUS(slotRequest.getSlotId(),
//                        slotRequest.getDoctorId(), slotRequest.getUserId(), Status.ACTIVE);
//
//        // Check if there is an appointment booked on the requested date
//        for (Appointment appointment : appointmentList) {
//            Long epochBookedDate = SlotRepositoryService.getLocalDate(appointment.getAppointmentDate())
//                    .toEpochDay();
//
//            if (epochBookedDate.equals(epochRequestedDate)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//
//}
