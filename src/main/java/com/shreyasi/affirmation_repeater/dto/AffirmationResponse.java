package com.shreyasi.affirmation_repeater.dto;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AffirmationResponse {

    private Long id;
    private String text;
    private LocalDateTime createdAt;
    private int repeatCount;
    public AffirmationResponse(Long id, String text, int repeatCount, LocalDateTime createdAt) {
        this.id = id;
        this.text = text;
        this.repeatCount = repeatCount;
        this.createdAt = createdAt;
    }

    // getters only (immutable DTO)
}
