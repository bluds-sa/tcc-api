package com.fatec.bluds.api.Domain.PasswordReset.DTO;

import jakarta.validation.constraints.NotBlank;

public record PasswordResetDTO(
        @NotBlank
        String token,

        @NotBlank
        String password
) {
}
