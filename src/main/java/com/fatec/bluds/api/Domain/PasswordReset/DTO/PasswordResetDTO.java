package com.fatec.bluds.api.domain.passwordReset.dto;

import jakarta.validation.constraints.NotBlank;

public record PasswordResetDTO(
        @NotBlank
        String token,

        @NotBlank
        String password
) {
}
