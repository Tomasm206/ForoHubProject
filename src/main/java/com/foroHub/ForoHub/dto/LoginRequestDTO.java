package com.foroHub.ForoHub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @NotBlank @Email(message = "Username is required") String correoElectronico,
        @NotBlank(message = "Password is required") String contrasena
) {
}
