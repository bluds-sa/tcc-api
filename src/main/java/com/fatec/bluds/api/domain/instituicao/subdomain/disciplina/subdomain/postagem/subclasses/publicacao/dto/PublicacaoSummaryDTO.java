package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.dto;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.model.Publicacao;

import java.time.LocalDateTime;

public record PublicacaoSummaryDTO(
        Long id,
        String titulo,
        LocalDateTime dataEnvio
) {
    public PublicacaoSummaryDTO(Publicacao publicacao) {
        this(
                publicacao.getId(),
                publicacao.getTitulo(),
                publicacao.getDataEnvio()
        );
    }
}
