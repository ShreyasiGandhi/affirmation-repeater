package com.shreyasi.affirmation_repeater.repository;

import com.shreyasi.affirmation_repeater.entity.AudioFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioFileRepository
        extends JpaRepository<AudioFile, Long> {
}
