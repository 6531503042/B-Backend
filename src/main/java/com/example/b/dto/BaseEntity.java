package com.example.b.dto;
import jakarta.persistence.Id;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    @Id
    public String id;
}
