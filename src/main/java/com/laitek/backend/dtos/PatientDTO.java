package com.laitek.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private Long id;

    private String name;

    private LocalDate date_of_birth;

    private String hospital;
}
