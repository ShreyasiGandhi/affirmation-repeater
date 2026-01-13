package com.shreyasi.affirmation_repeater.repository;

import com.shreyasi.affirmation_repeater.entity.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio, Long> {
}
