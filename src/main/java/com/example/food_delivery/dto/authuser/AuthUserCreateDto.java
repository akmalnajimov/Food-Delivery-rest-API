package com.example.food_delivery.dto.authuser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record AuthUserCreateDto(
        @NotBlank(message = "name must not be blank")
        String name,
        @Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "invalid email")
        @NotBlank(message = "email can not be blank")
        String email,
        @NotBlank(message = "email can not be blank")
        @Size(message = "password should include at least 2 characters", min = 2)
        String password,
        @NotBlank(message = "PhoneNumber must not be blank")
        String phoneNumber) {
}
