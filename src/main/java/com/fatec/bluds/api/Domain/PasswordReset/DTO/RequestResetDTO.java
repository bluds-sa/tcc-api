package com.fatec.bluds.api.domain.passwordReset.dto;

import jakarta.validation.constraints.Email;

public record RequestResetDTO(
        @Email
        String email
) {
}
