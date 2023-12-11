package com.worldwork.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "banners")
@Data
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "link", nullable = false)
    private String link;
}
