package com.shreyasi.affirmation_repeater.repository;

import com.shreyasi.affirmation_repeater.entity.Affirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AffirmationRepository extends JpaRepository<Affirmation, Long> {
}