package com.shreyasi.affirmation_repeater.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "affirmations")
public class Affirmation {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Affirmation text cannot be empty")
    @Size(min = 5, max = 300, message = "Affirmation must be between 5 and 300 characters")
    private String text;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;


    @Column(nullable = false)
    public int repeatCount = 0;


    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // --- JPA requires a no-arg constructor ---


   /* public Affirmation(String text) {
        this.text = text;
        this.createdAt = LocalDateTime.now();
    }*/

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}





