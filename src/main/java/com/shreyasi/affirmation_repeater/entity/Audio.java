package com.shreyasi.affirmation_repeater.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "audio" )
public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "affirmation_id" , nullable = false)
    private Affirmation affirmation;

    @Column(name = "file_path", nullable = false)
    private String filePath;
    @Enumerated(EnumType.STRING)
    @Column(name = "voice_type", nullable = false)
    private VoiceType voiceType;

    @Column(name="duration_seconds")
    private Long durationSeconds;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AudioStatus status;

    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.status = AudioStatus.GENERATED;
    }

}
