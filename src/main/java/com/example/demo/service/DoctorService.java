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

    
    public DoctorResponse add(DoctorRequest request) {
        Doctor doctor = new Doctor();
        doctor.setName(request.name());
        doctor.setLastName(request.lastName());
        doctor.setEmail(request.email());
        doctor.setSpecialty(request.specialty());

        Doctor saved = repo.add(doctor);
        return new DoctorResponse(saved.getId(), saved.getName(), saved.getLastName(), saved.getEmail(), saved.getSpecialty());
    }

    
    public List<Doctor> GetAll() {
        return repo.findAll().stream().collect(Collectors.toList());
    }

   
    public Doctor getById(UUID id) {
        return repo.findById(id);
    }

    
    public Doctor update(UUID id, Doctor NewDoctor) {
        NewDoctor.setId(id);
        return repo.update(NewDoctor);
    }

    
    public void DeleteDoctor(UUID id) {
        repo.deleteById(id);
    }

    
    public Doctor Getbyname(String name) {
        return repo.findByName(name);
    }
}
