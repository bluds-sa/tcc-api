package com.fatec.bluds.api.domain.usuario.dto.Enums;

import com.fatec.bluds.api.domain.usuario.model.Usuario;
import com.fatec.bluds.api.domain.usuario.roles.Roles;

import javax.management.relation.Role;

public record UsuarioSummaryDTO(
        Long id,
        String nome,
        String funcao
) {
    public UsuarioSummaryDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getRoles().obterNome()
        );
    }
}
