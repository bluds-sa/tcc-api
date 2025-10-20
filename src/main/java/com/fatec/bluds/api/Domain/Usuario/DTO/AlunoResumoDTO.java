package com.fatec.bluds.api.Domain.Disciplina.DTO;

public record AlunoResumoDTO(
        Long id,
        String nome,
        String email,
        String tipoUsuario
) {}
