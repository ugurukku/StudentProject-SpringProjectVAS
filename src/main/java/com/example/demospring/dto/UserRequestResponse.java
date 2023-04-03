package com.example.demospring.dto;


import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserRequestResponse(

        @NotNull(message = "fullName null olmamalidir")
        @NotEmpty(message = "fullName empty olmamalidir")
        @NotBlank(message = "fullName blank olmamalidir")
        @Email(message = "mutleq email daxil etmelisiniz")
        @Size(min = 4,message = "minimum uzunluq 4")
        String fullName,

        LocalDate age) {

}
