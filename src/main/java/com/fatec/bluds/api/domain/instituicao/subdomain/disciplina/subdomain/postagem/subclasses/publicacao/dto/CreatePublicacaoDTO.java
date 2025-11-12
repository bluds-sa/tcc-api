package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreatePublicacaoDTO(
        @NotBlank
        @Size(max = 120, message = "Título não pode ultrapassar 120 caracteres")
        String titulo,

        @NotBlank
        @Size(max = 5000, message = "Título não pode ultrapassar 120 caracteres")
        String conteudo,

        String caminhoAnexo,

        @NotNull
        Long disciplinaId,

        @NotNull
        Long educadorId
) {
}
