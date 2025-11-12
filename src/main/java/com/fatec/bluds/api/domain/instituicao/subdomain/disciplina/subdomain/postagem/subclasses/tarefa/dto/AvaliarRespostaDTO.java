package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AvaliarRespostaDTO(
        @NotNull(message = "ID da resposta é obrigatório")
        Long respostaId,

        @NotNull(message = "Nota é obrigatória")
        @Positive(message = "Nota deve ser positiva")
        Double nota,

        String comentario
) {}
