package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.CreateDisciplinaDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;

public interface DisciplinaService {
    Disciplina createDisciplina(CreateDisciplinaDTO dto);
}
