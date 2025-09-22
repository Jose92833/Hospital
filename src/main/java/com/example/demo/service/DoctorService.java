package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DoctorRequest;
import com.example.demo.dto.DoctorResponse;
import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
@Service
public class DoctorService {
    
    private final DoctorRepository repo;
    public DoctorService(DoctorRepository repo) {
        this.repo = repo;
    }

    public DoctorResponse add(DoctorRequest doctorRequest) {
        Doctor doctor = Doctor.builder()
                .name(doctorRequest.name())
                .lastName(doctorRequest.lastName())
                .email(doctorRequest.email())
                .specialty(doctorRequest.specialty())
                .build();
        
        repo.add(doctor);
        return toResponse(doctor);
    }

    private DoctorResponse toResponse(Doctor doctor) {
        return new DoctorResponse(
                doctor.getId(),
                doctor.getName(),
                doctor.getLastName(),
                doctor.getSpecialty(),
                doctor.getEmail()
        );
    }

    
}
