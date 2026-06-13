package com.gopiram.movie_ticket_resale.repository;

import com.gopiram.movie_ticket_resale.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
