package com.gopiram.movie_ticket_resale.repository;

import com.gopiram.movie_ticket_resale.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
