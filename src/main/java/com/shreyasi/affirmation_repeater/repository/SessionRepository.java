package com.shreyasi.affirmation_repeater.repository;

import com.shreyasi.affirmation_repeater.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
