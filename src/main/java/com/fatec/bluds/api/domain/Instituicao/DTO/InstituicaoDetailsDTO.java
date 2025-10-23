package com.fatec.bluds.api.domain.Instituicao.DTO;

import com.fatec.bluds.api.domain.Instituicao.Endereco.Endereco;
import com.fatec.bluds.api.domain.Instituicao.InstituicaoEnsino;

public record InstituicaoDetailsDTO(
        Long id,
        String nome,
        String telefone,
        String email,
        Endereco endereco
) {
    public InstituicaoDetailsDTO(InstituicaoEnsino instituicaoEnsino) {
        this(
                instituicaoEnsino.getId(),
                instituicaoEnsino.getNome(),
                instituicaoEnsino.getTelefone(),
                instituicaoEnsino.getEmail(),
                instituicaoEnsino.getEndereco()
        );
    }
}
