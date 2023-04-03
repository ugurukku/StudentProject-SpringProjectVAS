package com.example.demospring.dto;


import java.time.LocalDate;

public record UserRequestResponse(

        String fullName,

        LocalDate age) {

}
