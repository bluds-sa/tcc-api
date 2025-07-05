package com.fatec.bluds.api.Domain.Usuario.DTO;

import com.fatec.bluds.api.Domain.Usuario.Enums.Genero;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserCreationDTO(
        @NotBlank
        String nome,

        @NotBlank
        String cpf,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotNull
        Genero genero,

        @NotNull
        @PastOrPresent
        LocalDate dataNascimento,

        // TODO: VERIFICAR LÓGICA DE CRIAÇÃO DE INSTITUIÇÕES

        @NotBlank
        @Size(min = 8)
        // Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
        String senha
) {
}
