package com.example.demo.services;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Patient;
import com.example.demo.repositories.DoctorRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor saveDoctor(Doctor doctor) {
        // Additional validation or logic can be added here before saving
        return doctorRepository.save(doctor);
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    public List<Doctor> findDoctorsByCityAndSpeciality(Doctor.City city, Doctor.Speciality speciality) {
        return doctorRepository.findByCityAndSpeciality(city, speciality);
    }

	public Object addDoctor(@Valid Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeDoctor(Long id) {
		// TODO Auto-generated method stub
		
	}

	public List<Doctor> suggestDoctors(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

}


