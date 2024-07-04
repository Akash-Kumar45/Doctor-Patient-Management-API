package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 10)
    private String phoneNumber;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private City city;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    public enum City {
        DELHI, NOIDA, FARIDABAD
    }

    public enum Speciality {
        ORTHOPAEDIC, GYNECOLOGY, DERMATOLOGY, ENT
    }
}

