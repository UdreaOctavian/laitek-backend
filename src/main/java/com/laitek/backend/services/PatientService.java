package com.laitek.backend.services;

import com.laitek.backend.dtos.PatientDTO;
import com.laitek.backend.dtos.builders.PatientBuilder;
import com.laitek.backend.entities.Patient;
import com.laitek.backend.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<PatientDTO> getAll() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientBuilder::toPatientDTO).collect(Collectors.toList());
    }
}
