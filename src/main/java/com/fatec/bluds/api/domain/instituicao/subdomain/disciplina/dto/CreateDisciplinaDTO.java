package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateDisciplinaDTO(
        @NotBlank(message = "Nome da disciplina não pode ser vazio ou nulo")
        String nome,

        @NotBlank(message = "Descrição da disciplina não pode ser vazio ou nulo")
        String descricao,

        @NotNull
        Long idEducadorResponsavel,

        @NotNull
        Long idInstituicao
) {
}
