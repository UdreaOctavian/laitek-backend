package com.laitek.backend.dtos.builders;

import com.laitek.backend.dtos.PatientDTO;
import com.laitek.backend.entities.Patient;

public class PatientBuilder {

    private PatientBuilder() {
    }

    public static PatientDTO toPatientDTO(Patient patient) {
        if (patient == null)
            return null;
        return PatientDTO.builder().
                id(patient.getId()).
                name(patient.getName()).
                date_of_birth(patient.getDate_of_birth()).
                hospital(patient.getHospital()).
                build();
    }

    public static Patient toEntity(PatientDTO patientDTO) {
        if (patientDTO == null)
            return null;
        return Patient.builder().
                id(patientDTO.getId()).
                name(patientDTO.getName()).
                date_of_birth(patientDTO.getDate_of_birth()).
                hospital(patientDTO.getHospital()).
                build();
    }
}
