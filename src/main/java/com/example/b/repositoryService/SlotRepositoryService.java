//package com.example.b.repositoryService;
//
//import com.example.b.dto.Slot;
//import com.example.b.exchanges.SlotBookingRequest;
//import com.example.b.repository.SlotRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import lombok.Data;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.security.Provider;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Date;
//import java.util.List;
//import java.util.TimeZone;
//
//@Service
//@Log4j2
//public class SlotRepositoryService {
//
//    public static final long Min_SLOT_DURATION = 900000;
//    public static final long MAX_SLOT_DURATION = 18000000;
//    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
//    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
//
//
//    @Autowired
//    private SlotRepository slotRepository;
//
//    @Autowired
//    private AppointmentRepositoryService appointmentRepositoryService;
//
//    @Autowired
//    private final ObjectMapper mapper = new ObjectMapper()
//            .configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, true);
//
//    static LocalDate getLocalDate(Data date) {
//        return date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
//    }
//
//    private static LocalTime getLocalTime(Date date) {
//        return date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalTime();
//    }
//
//    public ResponseEntity<?> bookSlot (SlotBookingRequest slotRequest) {
//
//        Slot requestedSlot = getAppointmentSlotById(slotRequest.getDoctorId(), slotRequest.getSlotId());
//
//        if (requestedSlot == null) {
//            return ResponseEntity.badRequest().body("Requested slot not found");
//        }
//
//        Long epochRequestedDate = getLocalDate((Data) slotRequest.getBookingDate()).toEpochDay();
//
//        if (appointmentRepositoryService.alreadyExist(slotRequest, epochRequestedDate)) {
//            return ResponseEntity.badRequest().body("Slot already booked");
//        }
//        return null;
//    }
//
//    public Slot getAppointmentSlotById(String doctorId, String slotId) {
//        List<Slot> slots = slotRepository.getAllByDoctorId(doctorId);
//        for (Slot currentSlot : slots) {
//            if (currentSlot.id.equals(slotId)) {
//                return currentSlot;
//            }
//        }
//        return null;
//    }
//
//    public ResponseEntity<?> createSlot(Slot slot) {
//        if (slot.getStartTime().compareTo(slot.getEndTime()) >= 0) {
//            return ResponseEntity.badRequest().body("End Time must be greater than Start time");
//        }
//
//        if (slotDuration < Min_SLOT_DURATION || slotDuration > MAX_SLOT_DURATION) {
//            return ResponseEntity.badRequest().body("Slot duration must be between 15 min and 30 hours");
//        }
//
//        login slotDuration = slot.getEndTime().getTime() - slot.getStartTime().getTime();
//
//    }
//}
