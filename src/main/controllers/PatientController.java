package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Patient;
import com.example.demo.services.DoctorService;
import com.example.demo.services.PatientService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/patients")
    public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) {
        return ResponseEntity.ok(PatientService.addPatient(patient));
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Void> removePatient(@PathVariable Long id) {
        PatientService.removePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/patients/{id}/suggest-doctors")
    public ResponseEntity<?> suggestDoctors(@PathVariable Long id) {
        Optional<Patient> patientOpt = patientService.getPatient(id);

        if (!patientOpt.isPresent()) {
            return ResponseEntity.badRequest().body("Patient not found");
        }

        Patient patient = patientOpt.get();
        List<Doctor> doctors = doctorService.suggestDoctors(patient);

        if (doctors.isEmpty()) {
            return ResponseEntity.ok("There isn’t any doctor present at your location for your symptom");
        }

        return ResponseEntity.ok(doctors);
    }
}

