package com.example.demospring.dto;

import java.time.LocalDate;

public record UserDTO(
        String fullName,
        LocalDate age) {

}
