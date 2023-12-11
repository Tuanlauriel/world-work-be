package com.worldwork.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "job_applications")
@Data
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private Job job;

    @Column(name = "cover_letter", nullable = false, columnDefinition = "TEXT")
    private String coverLetter;

    @Column(name = "cv", nullable = false)
    private String cv;

    @Column(name = "status", nullable = false)
    private String status;

}
