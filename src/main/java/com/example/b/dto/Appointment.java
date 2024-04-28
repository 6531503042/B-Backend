package com.example.b.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment extends BaseEntity {

    private String doctorId;

    private String userId;

    private Data appointmentDate;

    private String slotId;

    private Status STATUS;
}
