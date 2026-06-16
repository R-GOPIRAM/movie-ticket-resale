package com.gopiram.movie_ticket_resale.auth;

import com.gopiram.movie_ticket_resale.entity.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String fullName;
    private String email;
    private String password;
    private UserRole role;
}
