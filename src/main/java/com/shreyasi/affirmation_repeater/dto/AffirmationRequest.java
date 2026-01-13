package com.shreyasi.affirmation_repeater.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AffirmationRequest {

    @NotBlank(message = "Affirmation text cannot be empty")
    @Size(min = 3, max = 255, message = "Affirmation must be between 3 and 255 characters")
    private String text;


}

