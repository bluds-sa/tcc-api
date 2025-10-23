package com.fatec.bluds.api.domain.Usuario.DTO;

import com.fatec.bluds.api.domain.Instituicao.DTO.InstituicaoDetailsDTO;
import com.fatec.bluds.api.domain.Usuario.Enums.Genero;
import com.fatec.bluds.api.domain.Usuario.Roles.Roles;
import com.fatec.bluds.api.domain.Usuario.Usuario;

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
