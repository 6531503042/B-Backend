package com.example.b.models;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorModel {

    @Id
    private Long id;

    private String name;

    private String specialization;
}
