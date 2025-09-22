package com.example.demo.repository;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Doctor;   
@Repository
public class DoctorRepository {
    
    private final Map<UUID, Doctor> data = new ConcurrentHashMap<>();

    public Doctor add(Doctor doctor){
        if(doctor.getId() == null)
            doctor.setId(UUID.randomUUID());
        data.put(doctor.getId(), doctor);
        return doctor;
    }
    public Doctor findById(UUID id){
        return data.get(id);
    }   
    public void deleteById(UUID id){
        data.remove(id);

    }
    public Doctor update(Doctor doctor){
        if (doctor.getId() == null || !data.containsKey(doctor.getId())){
            throw new IllegalArgumentException("Doctor with id " + doctor.getId() + " does not exist.");
        }
        return data.put(doctor.getId(), doctor);
    }
    public Collection<Doctor> findAll(){
        return data.values();
    }
    
    


       
    
}
