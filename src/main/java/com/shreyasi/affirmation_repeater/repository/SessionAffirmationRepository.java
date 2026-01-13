package com.shreyasi.affirmation_repeater.repository;

import com.shreyasi.affirmation_repeater.entity.SessionAffirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionAffirmationRepository extends JpaRepository<SessionAffirmation, Long> {
}
