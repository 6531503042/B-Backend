package com.example.b.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class SlotStatusRequest {

    private String doctorId;

    private String userId;

    private Date currentDate;
}
