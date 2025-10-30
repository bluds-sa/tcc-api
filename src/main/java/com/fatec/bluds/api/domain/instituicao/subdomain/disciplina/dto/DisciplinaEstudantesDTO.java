package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto;

import com.fatec.bluds.api.domain.usuario.subclasses.estudante.dto.EstudanteSummaryDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.model.Estudante;
import java.util.ArrayList;
import java.util.List;

public record DisciplinaEstudantesDTO(
        List<EstudanteSummaryDTO> estudantes
) {
    public DisciplinaEstudantesDTO(ArrayList<Estudante> listaEstudantes) {
        this(listaEstudantes.stream().map(EstudanteSummaryDTO::new).toList());
    }
}