package com.worldwork.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "job_fields")
@Data
public class JobField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

}
