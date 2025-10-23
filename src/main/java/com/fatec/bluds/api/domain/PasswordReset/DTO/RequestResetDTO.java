package com.fatec.bluds.api.domain.PasswordReset.DTO;

import jakarta.validation.constraints.Email;

public record RequestResetDTO(
        @Email
        String email
) {
}
