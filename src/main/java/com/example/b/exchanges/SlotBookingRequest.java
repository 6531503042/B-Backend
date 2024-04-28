package com.example.b.exchanges;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class SlotBookingRequest {

    @NotNull
    private String DoctorId;

    @NotNull
    private String slotId;

    @NotNull
    private Date bookingDate;

    @NotNull
    private String userId;
}
