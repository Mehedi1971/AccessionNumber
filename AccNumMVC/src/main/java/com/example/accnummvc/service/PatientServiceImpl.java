package com.example.accnummvc.service;

import com.example.accnummvc.entity.Patient;
import com.example.accnummvc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{
   @Autowired
   private PatientRepository patientRepository;

    @Override
    public void savesampleacc(Patient patient) {
        this.patientRepository.save(patient);
    }

    @Override
    public Object getAll() {
        return null;
    }
}
