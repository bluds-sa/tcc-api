package com.fatec.bluds.api.domain.usuario.subclasses.Gestor.DTO;

import com.fatec.bluds.api.domain.usuario.enums.Genero;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record UpdateGestorDTO(
        String nome,
        String telefone,
        Genero genero,
        @PastOrPresent
        LocalDate dataNascimento,
        String matricula,
        String cargo
) {
}
