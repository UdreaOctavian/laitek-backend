package com.laitek.backend.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "patient_table")
@Entity

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate date_of_birth;

    @Column(nullable = false)
    private String hospital;
}
