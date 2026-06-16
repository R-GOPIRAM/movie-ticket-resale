package com.gopiram.movie_ticket_resale.auth;

import com.gopiram.movie_ticket_resale.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.gopiram.movie_ticket_resale.entity.User;

@Service
public class AuthService {
    private final UserRepository userRepository;
    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User register(RegisterRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }
        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return userRepository.save(user);
    }
}
