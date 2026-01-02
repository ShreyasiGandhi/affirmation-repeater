package com.shreyasi.affirmation_repeater.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class AffirmationResponse {

    private Long id;
    private String text;
    private LocalDateTime createdAt;

    public AffirmationResponse(Long id, String text, LocalDateTime createdAt) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
    }

    // getters only (immutable DTO)
}
