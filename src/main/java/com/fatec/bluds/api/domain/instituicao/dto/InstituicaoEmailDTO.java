package com.fatec.bluds.api.domain.instituicao.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record InstituicaoEmailDTO(
        @Email
        @NotBlank
        String email
) {
}
