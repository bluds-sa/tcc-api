package com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.DTO;

import com.fatec.bluds.api.Domain.Usuario.Enums.Genero;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record EstudanteUpdateDTO(
        String telefone,
        @NotNull(message = "Gênero é obrigatório")
        Genero genero,
        @NotNull(message = "Data de nascimento é obrigatória")
        LocalDate dataNascimento
) {}
