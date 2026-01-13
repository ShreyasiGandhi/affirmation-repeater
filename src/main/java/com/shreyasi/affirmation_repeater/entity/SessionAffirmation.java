package com.shreyasi.affirmation_repeater.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "session_affirmations")
public class SessionAffirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "affirmation_id",nullable = false)
    private Affirmation affirmation;

    @Column(name = "sequence_order", nullable = false)
    private Integer sequenceOrder;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

     @PrePersist
    public void onCreate(){
         this.createdAt = LocalDateTime.now();
     }
}
