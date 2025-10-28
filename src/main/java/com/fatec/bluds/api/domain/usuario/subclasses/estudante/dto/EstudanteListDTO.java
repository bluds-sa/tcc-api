package com.fatec.bluds.api.domain.usuario.subclasses.estudante.DTO;

import com.fatec.bluds.api.domain.usuario.subclasses.estudante.Enums.AnoEscolar;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.Enums.Periodo;

public record EstudanteListDTO(
    Long id,
    String nome,
    String email,
    String matricula,
    AnoEscolar anoEscolar,
    Periodo periodo
) {}
