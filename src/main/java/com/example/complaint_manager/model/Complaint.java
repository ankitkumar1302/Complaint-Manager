package com.example.complaint_manager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false, length = 1000)
    private String description;

    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime registrationDateTime;

    @Column(nullable = false)
    private String status;


    // Getters and Setters
}
