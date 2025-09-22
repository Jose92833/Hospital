package com.example.demo.dto;

import java.util.UUID;

public record  DoctorResponse (
     UUID id,
     String name,
     String lastName,
     String email,
     String specialty
){}
   


