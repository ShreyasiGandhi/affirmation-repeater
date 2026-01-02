package com.shreyasi.affirmation_repeater.service;

import com.shreyasi.affirmation_repeater.dto.AffirmationResponse;
import com.shreyasi.affirmation_repeater.entity.Affirmation;
import com.shreyasi.affirmation_repeater.exception.ResourceNotFoundException;
import com.shreyasi.affirmation_repeater.repository.AffirmationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AffirmationService {

    private final AffirmationRepository repository;

    public AffirmationService(AffirmationRepository repository) {
        this.repository = repository;
    }

    public Affirmation saveAffirmation(Affirmation affirmation) {
        return repository.save(affirmation);
    }

    public List<Affirmation> getAllAffirmations() {
        return repository.findAll();
    }
    public Affirmation getAffirmationById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Affirmation not found with id " + id));
    }
    public Page<AffirmationResponse> getAffirmations(Pageable pageable) {
        return repository.findAll(pageable)
                .map(this::mapToResponse);
    }
    private AffirmationResponse mapToResponse(Affirmation affirmation) {
        return new AffirmationResponse(
                affirmation.getId(),
                affirmation.getText(),
                affirmation.getCreatedAt()
        );
    }
    public AffirmationResponse getRandomAffirmation() {

        List<Affirmation> affirmations = repository.findAll();

        if (affirmations.isEmpty()) {
            throw new ResourceNotFoundException("No affirmations available");
        }

        int randomIndex = new Random().nextInt(affirmations.size());

        return mapToResponse(affirmations.get(randomIndex));
    }

}
