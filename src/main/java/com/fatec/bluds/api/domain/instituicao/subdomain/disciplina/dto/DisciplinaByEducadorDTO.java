package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto;

import jakarta.validation.constraints.NotNull;

public record DisciplinaByEducadorDTO(
        @NotNull
        Long idEducadorResponsavel
) {
}
