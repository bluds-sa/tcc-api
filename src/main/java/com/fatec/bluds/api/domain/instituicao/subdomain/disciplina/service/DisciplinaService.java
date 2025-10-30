package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.*;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;

import java.util.List;

public interface DisciplinaService {
    Disciplina createDisciplina(CreateDisciplinaDTO dto);
    List<Disciplina> getDisciplinasByEstudante(DisciplinaByEstudanteDTO dto);
    List<Disciplina> getDisciplinasByInstituicao(DisciplinaByInstituicaoDTO dto);
    Disciplina updateDisciplina(UpdateDisciplinaDTO dto);
    DisciplinaEstudantesDTO addEstudanteToDisciplina(DisciplinaByEstudanteDTO dto);
    DisciplinaEstudantesDTO removeEstudanteFromDisciplina(DisciplinaByEstudanteDTO dto);
}
