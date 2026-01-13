package com.shreyasi.affirmation_repeater.repository;



import com.shreyasi.affirmation_repeater.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
