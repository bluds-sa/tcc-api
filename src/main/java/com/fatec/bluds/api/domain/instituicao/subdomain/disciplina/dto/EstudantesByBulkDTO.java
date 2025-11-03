package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record EstudantesByBulkDTO(

        @NotNull(message = "O ID da disciplina é obrigatório")
        Long disciplinaId,

        @NotEmpty(message = "A lista de estudantes não pode estar vazia")
        List<Long> estudanteIds
) {}
