package com.fatec.bluds.api.domain.instituicao.DTO;

import com.fatec.bluds.api.domain.instituicao.endereco.Endereco;
import com.fatec.bluds.api.domain.instituicao.InstituicaoEnsino;

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
