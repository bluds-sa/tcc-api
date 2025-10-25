package com.fatec.bluds.api.domain.usuario.subclasses.Estudante.DTO;

import com.fatec.bluds.api.domain.usuario.enums.Genero;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record EstudanteUpdateDTO(
        String nome,
        String telefone,
        Genero genero,
        LocalDate dataNascimento
) {}
