package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.CreateDisciplinaDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.ListDisciplinaByEstudanteDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.ListDisciplinaByInstituicaoDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.UpdateDisciplinaDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;

import java.util.List;

public interface DisciplinaService {
    Disciplina createDisciplina(CreateDisciplinaDTO dto);
    List<Disciplina> getDisciplinasByEstudante(ListDisciplinaByEstudanteDTO dto);
    List<Disciplina> getDisciplinasByInstituicao(ListDisciplinaByInstituicaoDTO dto);
    Disciplina updateDisciplina(UpdateDisciplinaDTO dto);
}
