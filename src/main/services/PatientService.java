package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private static PatientRepository patientRepository;

    public static Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public static void removePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public Optional<Patient> getPatient(Long id) {
        return patientRepository.findById(id);
    }
}
