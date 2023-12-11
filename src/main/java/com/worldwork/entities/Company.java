package com.worldwork.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "companies")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "business_license", nullable = false)
    private String business_license;

    @Column(name = "logo", nullable = false)
    private String logo;

    @Column(name = "status", nullable = false)
    private boolean status;
}
