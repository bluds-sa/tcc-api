package com.fatec.bluds.api.domain.instituicao.dto;

import com.fatec.bluds.api.domain.instituicao.model.InstituicaoEnsino;
import com.fatec.bluds.api.domain.usuario.dto.Enums.UsuarioSummaryDTO;

import java.util.List;

public record InstituicaoMembersDTO(
        Long id,
        String instituicao,
        List<UsuarioSummaryDTO> membros
) {
    public InstituicaoMembersDTO(InstituicaoEnsino inst) {
        this(
                inst.getId(),
                inst.getNome(),
                inst.getUsuarios().stream().map(UsuarioSummaryDTO::new).toList()
        );
    }
}
