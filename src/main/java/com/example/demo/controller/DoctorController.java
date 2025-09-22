package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DoctorRequest;
import com.example.demo.dto.DoctorResponse;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping("api/v1/doctors")

public class DoctorController {
    
    private final DoctorService service;
    public DoctorController(DoctorService service) {
        this.service = service;
    }
    @PostMapping
    public DoctorResponse add(DoctorRequest doctorRequest){
 return service.add(doctorRequest);
    }
    
}
