package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Doctor;
import com.example.demo.services.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctors")
    public ResponseEntity<Object> addDoctor(@Valid @RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.addDoctor(doctor));
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<Void> removeDoctor(@PathVariable Long id) {
        doctorService.removeDoctor(id);
        return ResponseEntity.noContent().build();
    }
}

