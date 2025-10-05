package com.fatec.bluds.api.Domain.PasswordReset.DTO;

import jakarta.validation.constraints.Email;

public record RequestResetDTO(
        @Email
        String email
) {
}
