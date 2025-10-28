package com.fatec.bluds.api.domain.usuario.subclasses.gestor.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record GestorGetByEmailDTO(
        @NotBlank
        @Email
        String email
) {
}
