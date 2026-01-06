package com.shreyasi.affirmation_repeater.controller;

import com.shreyasi.affirmation_repeater.dto.AffirmationResponse;
import com.shreyasi.affirmation_repeater.entity.Affirmation;
import com.shreyasi.affirmation_repeater.service.AffirmationService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/affirmations")
public class AffirmationController {

    private final AffirmationService service;

    public AffirmationController(AffirmationService service) {
        this.service = service;
    }

    // 1️⃣ Create an affirmation
    @PostMapping
    public ResponseEntity<Affirmation> createAffirmation(
            @Valid @RequestBody Affirmation affirmation) {
        return ResponseEntity.ok(service.saveAffirmation(affirmation));
    }


    // 2️⃣ Get all affirmations
    @GetMapping
    public List<Affirmation> getAllAffirmations() {
        return service.getAllAffirmations();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Affirmation> getAffirmationById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAffirmationById(id));
    }

    @GetMapping("/paged")
    public Page<AffirmationResponse> getAffirmationsPaged(
            @PageableDefault(size = 5, sort = "createdAt") Pageable pageable) {

        return service.getAffirmations(pageable);
    }

    @GetMapping("/random")
    public ResponseEntity<AffirmationResponse> getRandomAffirmation() {
        return ResponseEntity.ok(service.getRandomAffirmation());
    }

    @PostMapping("/{id}/repeat")
    public ResponseEntity<AffirmationResponse> repeatAffirmation(@PathVariable Long id) {
        AffirmationResponse updated = service.repeatAffirmation(id);
        return ResponseEntity.ok(updated);

    }


}

