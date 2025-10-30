package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto;

import jakarta.validation.constraints.NotNull;

public record DisciplinaByEstudanteDTO(
        @NotNull
        Long estudanteId
) {
}
