package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.dto;

public record UpdatePublicacaoDTO(
        String titulo,
        String conteudo,
        String caminhoAnexo
) {
}
