package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Patient {
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
    @Size(max = 20)
    private String city;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Symptom symptom;

    public enum Symptom {
        ARTHRITIS, BACK_PAIN, TISSUE_INJURIES, DYSMENORRHEA, SKIN_INFECTION, SKIN_BURN, EAR_PAIN
    }

	public Symptom getSymptom() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCity() {
		// TODO Auto-generated method stub
		return null;
	}
}


