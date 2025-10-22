package com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.DTO;

import com.fatec.bluds.api.Domain.Usuario.Enums.Genero;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Enums.AnoEscolar;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Enums.Periodo;
import java.time.LocalDate;

public record EstudanteResponseDTO(
    Long id,
    String nome,
    String cpf,
    String email,
    String matricula,
    Periodo periodo,
    AnoEscolar anoEscolar,
    String telefone,
    Genero genero,
    LocalDate dataNascimento
) {}
