package com.fatec.bluds.api.domain.usuario.dto;

import com.fatec.bluds.api.domain.usuario.model.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema
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
