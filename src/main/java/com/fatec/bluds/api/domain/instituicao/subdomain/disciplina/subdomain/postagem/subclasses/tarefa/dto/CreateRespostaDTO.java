package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.dto;

import jakarta.validation.constraints.NotNull;

public record CreateRespostaDTO(
        @NotNull Long tarefaId,
        @NotNull Long estudanteId,
        String caminhoAnexo,
        String conteudoTexto
) {}
