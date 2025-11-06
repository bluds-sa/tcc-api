package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;

public record DisciplinaSummaryDTO(
        Long id,
        String nome,
        String descricao,
        String educadorResponsavel,
        String instituicao
) {
    public DisciplinaSummaryDTO(Disciplina disciplina) {
        this(
                disciplina.getId(),
                disciplina.getNome(),
                disciplina.getDescricao(),
                disciplina.getEducador().getNome(),
                disciplina.getInstituicaoEnsino().getNome()
        );
    }
}
