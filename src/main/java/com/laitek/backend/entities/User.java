package com.laitek.backend.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user_table")
@Entity

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean is_admin;
}
