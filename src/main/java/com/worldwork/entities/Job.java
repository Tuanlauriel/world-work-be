package com.worldwork.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "offer", columnDefinition = "TEXT")
    private String offer;

    @Column(name = "requirement", columnDefinition = "TEXT")
    private String requirement;

    @Column(name = "salary", nullable = false)
    private int salary;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "featured", nullable = false)
    private boolean featured;

    @Column(name = "location", nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "field_id", referencedColumnName = "id")
    private JobField jobField;

    @ManyToOne
    @JoinColumn(name = "recruiter_id", referencedColumnName = "id")
    private User recruiter;

}
