package com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.DTO;

import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Enums.AnoEscolar;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Enums.Periodo;

public record EstudanteListDTO(
    Long id,
    String nome,
    String email,
    String matricula,
    AnoEscolar anoEscolar,
    Periodo periodo
) {}
