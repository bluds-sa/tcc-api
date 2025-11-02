package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto;

import com.fatec.bluds.api.domain.usuario.dto.Enums.UsuarioSummaryDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.model.Estudante;
import java.util.ArrayList;
import java.util.List;

public record DisciplinaEstudantesDTO(
        List<UsuarioSummaryDTO> estudantes
) {
    public DisciplinaEstudantesDTO(ArrayList<Estudante> listaEstudantes) {
        this(listaEstudantes.stream().map(UsuarioSummaryDTO::new).toList());
    }
}