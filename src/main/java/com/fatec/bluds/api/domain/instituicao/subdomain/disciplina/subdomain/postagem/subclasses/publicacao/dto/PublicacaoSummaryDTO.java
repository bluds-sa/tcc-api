package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.dto;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.model.Publicacao;

public record PublicacaoSummaryDTO(
        Long id,
        String titulo
) {
    public PublicacaoSummaryDTO(Publicacao publicacao) {
        this(
                publicacao.getId(),
                publicacao.getTitulo()
        );
    }
}
