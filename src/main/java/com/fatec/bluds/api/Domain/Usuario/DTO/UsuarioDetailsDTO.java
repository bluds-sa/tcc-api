package com.fatec.bluds.api.Domain.Usuario.DTO;

import com.fatec.bluds.api.Domain.Instituicao.InstituicaoEnsino;
import com.fatec.bluds.api.Domain.Usuario.Enums.Genero;
import com.fatec.bluds.api.Domain.Usuario.Roles.Roles;
import com.fatec.bluds.api.Domain.Usuario.Usuario;

import java.time.LocalDate;

public record UsuarioDetailsDTO(
        String nome,
        String email,
        String telefone,
        Genero genero,
        LocalDate dataNascimento,
        InstituicaoEnsino instituicaoEnsino,
        Roles roles
) {
     UsuarioDetailsDTO(Usuario usuario) {
        this(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getGenero(),
                usuario.getDataNascimento(),
                usuario.getInstituicaoEnsino(),
                usuario.getRoles()
        );
    }
}
