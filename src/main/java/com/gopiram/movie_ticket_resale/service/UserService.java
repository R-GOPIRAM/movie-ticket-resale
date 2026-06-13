package com.gopiram.movie_ticket_resale.service;

import com.gopiram.movie_ticket_resale.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.gopiram.movie_ticket_resale.entity.User;
import java.util.List;

@Service
public class UserService  {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository =userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

