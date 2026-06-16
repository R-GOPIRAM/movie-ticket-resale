package com.gopiram.movie_ticket_resale.auth;

import com.gopiram.movie_ticket_resale.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.gopiram.movie_ticket_resale.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User register(RegisterRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }
        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );
        user.setRole(request.getRole());

        return userRepository.save(user);
    }
    public User login(LoginRequest request){
        User user = userRepository.findByEmail(
                request.getEmail()
        ).orElseThrow(()->
                new RuntimeException("User not found")
        );
        if(
                !passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                )
        )
        {
            throw new RuntimeException("Invalid password");
        }
        return user;
    }
}
