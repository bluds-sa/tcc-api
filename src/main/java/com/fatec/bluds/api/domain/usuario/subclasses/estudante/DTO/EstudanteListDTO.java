package com.fatec.bluds.api.domain.usuario.subclasses.Estudante.DTO;

import com.fatec.bluds.api.domain.usuario.subclasses.Estudante.Enums.AnoEscolar;
import com.fatec.bluds.api.domain.usuario.subclasses.Estudante.Enums.Periodo;

public record EstudanteListDTO(
    Long id,
    String nome,
    String email,
    String matricula,
    AnoEscolar anoEscolar,
    Periodo periodo
) {}
