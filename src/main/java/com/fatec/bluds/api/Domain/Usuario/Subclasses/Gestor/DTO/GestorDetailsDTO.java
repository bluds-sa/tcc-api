package com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.DTO;

import com.fatec.bluds.api.Domain.Instituicao.DTO.InstituicaoDetailsDTO;
import com.fatec.bluds.api.Domain.Usuario.Enums.Genero;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.Gestor;

import java.time.LocalDate;

public record GestorDetailsDTO(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        Genero genero,
        LocalDate dataNascimento,
        String cargo,
        InstituicaoDetailsDTO instituicao
) {
    public GestorDetailsDTO(Gestor gestor) {
        this(
                gestor.getId(),
                gestor.getNome(),
                gestor.getCpf(),
                gestor.getEmail(),
                gestor.getTelefone(),
                gestor.getGenero(),
                gestor.getDataNascimento(),
                gestor.getCargo(),
                new InstituicaoDetailsDTO(gestor.getInstituicaoEnsino())
        );
    }
}
