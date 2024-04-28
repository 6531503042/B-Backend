package com.example.b.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends BaseEntity {

    private String name;

    private String phoneNumber;

    private String email;

    private int experience;

    private String about;

    private Status status;
}
