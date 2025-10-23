package com.fatec.bluds.api.domain.usuario.dto;

import com.fatec.bluds.api.domain.instituicao.DTO.InstituicaoDetailsDTO;
import com.fatec.bluds.api.domain.usuario.enums.Genero;
import com.fatec.bluds.api.domain.usuario.roles.Roles;
import com.fatec.bluds.api.domain.usuario.Usuario;

import java.time.LocalDate;

public record UsuarioDetailsDTO(
        String nome,
        String email,
        String telefone,
        Genero genero,
        LocalDate dataNascimento,
        InstituicaoDetailsDTO instituicao,
        Roles roles
) {
     public UsuarioDetailsDTO(Usuario usuario) {
        this(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getGenero(),
                usuario.getDataNascimento(),
                usuario.getInstituicaoEnsino() != null ? new InstituicaoDetailsDTO(usuario.getInstituicaoEnsino()) : null,
                usuario.getRoles()
        );
    }
}
