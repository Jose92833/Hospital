package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DoctorRequest;
import com.example.demo.dto.DoctorResponse;
import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("api/v1/doctors")

public class DoctorController {
    
    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping("/doctor")
    public DoctorResponse add(@RequestBody DoctorRequest doctorRequest) {
        return service.add(doctorRequest);
    }

    @GetMapping("/doctor")
    public List<Doctor> GetAllDoctor() {
        return service.GetAll();
    }

    @GetMapping("/doctor/{id}")
    public Doctor getbyidDoctor(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PutMapping("/doctor/{id}")
    public Doctor UpdateDoctor(@PathVariable UUID id, @RequestBody Doctor NewDoctor) {
        return service.update(id, NewDoctor);
    }

    @DeleteMapping("/doctor/{id}")
    public void DeleteDoctor(@PathVariable UUID id) {
        service.DeleteDoctor(id);
    }

    
    @GetMapping("/doctor/name/{name}")
    public Doctor Getbyname(@PathVariable String name) {
        return service.Getbyname(name);
    }
}

