package com.shreyasi.affirmation_repeater.repository;


import com.shreyasi.affirmation_repeater.entity.Affirmation;
import com.shreyasi.affirmation_repeater.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
class AffirmationRepositoryTest {
    @Autowired
    private AffirmationRepository affirmationRepository;

    @Autowired
    private UserRepository userRepository;


    private AffirmationRepository repository;
    // 1. Create User

   // user.("test_user");

    // 2. Save User FIRST



    @Test
    void shouldSaveAffirmation() {
        User user = new User();
        user.setName("test_user");
        user.setEmail("test_user@test.com");
        user.setActive(true);

        User savedUser = userRepository.save(user);

        // 3. Create Affirmation
        Affirmation affirmation = new Affirmation();
        affirmation.setText("I am learning Spring Boot testing");
        affirmation.setRepeatCount(0);
        affirmation.setCreatedAt(LocalDateTime.now());
        affirmation.setCreatedBy(savedUser); // THIS FIXES YOUR ERROR

        // 4. Save Affirmation
        Affirmation savedAffirmation = affirmationRepository.save(affirmation);

        // 5. Assertion
        // Assert
        assertThat(savedAffirmation.getId()).isNotNull();
        assertThat(savedAffirmation.getCreatedBy()).isNotNull();
    }
}
