package com.example.demo.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Doctor {
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private String specialty; 
    
}
