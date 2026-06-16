package com.gopiram.movie_ticket_resale.service;

import com.gopiram.movie_ticket_resale.MovieTicketResaleApplication;
import com.gopiram.movie_ticket_resale.repository.UserRepository;
import org.springframework.boot.SpringApplication;
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
    public User createUser(User user){
        return userRepository.save(user);
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    public User updateUser(Long id,User updateUser){
        User existingUser = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));

        existingUser.setFullName(updateUser.getFullName());
        existingUser.setEmail(updateUser.getEmail());
        existingUser.setPassword(updateUser.getPassword());
        existingUser.setRole(updateUser.getRole());

        return userRepository.save(existingUser);
    }
}

