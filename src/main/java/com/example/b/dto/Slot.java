package com.example.b.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class Slot extends BaseEntity {

    @NotNull
    private Date startTime;

    @NotNull
    private Date endTime;

    @NotNull
    private String doctorId;

    private boolean isBooked;

    private boolean isBookedBySameUser;

}
