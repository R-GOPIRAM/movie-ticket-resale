package com.gopiram.movie_ticket_resale.auth;

import com.gopiram.movie_ticket_resale.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(
            @RequestBody RegisterRequest request
    ) {
        return authService.register(request);
    }
}