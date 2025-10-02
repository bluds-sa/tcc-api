package com.fatec.bluds.api.Domain.Usuario.DTO;

import jakarta.validation.constraints.Email;

public record PasswordResetDTO(
        @Email
        String email
) {
}
