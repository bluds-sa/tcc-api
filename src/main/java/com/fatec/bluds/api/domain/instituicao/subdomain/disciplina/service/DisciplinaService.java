package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.*;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.model.Estudante;

import java.util.List;

public interface DisciplinaService {
    Disciplina createDisciplina(CreateDisciplinaDTO dto);
    List<Disciplina> getDisciplinasByEstudante(DisciplinaByEstudanteDTO dto);
    List<Disciplina> getDisciplinasByInstituicao(DisciplinaByInstituicaoDTO dto);
    Disciplina updateDisciplina(UpdateDisciplinaDTO dto);
    List<Estudante> addEstudanteToDisciplina(DisciplinaByEstudanteDTO dto);
    List<Estudante> removeEstudanteFromDisciplina(DisciplinaByEstudanteDTO dto);
    List<Estudante> enrollByBulk(EstudantesByBulkDTO dto);
    List<Estudante> unenrollByBulk(EstudantesByBulkDTO dto);
}
