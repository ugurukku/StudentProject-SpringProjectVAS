package com.example.demospring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @Email
        String email,
        @Size(min = 6)
        String password
) {
}
