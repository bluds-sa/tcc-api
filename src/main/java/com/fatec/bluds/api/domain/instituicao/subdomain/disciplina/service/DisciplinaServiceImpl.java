package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.*;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaServiceImpl implements DisciplinaService{

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public Disciplina createDisciplina(CreateDisciplinaDTO dto) {
        return null;
    }

    @Override
    public List<Disciplina> getDisciplinasByEstudante(DisciplinaByEstudanteDTO dto) {
        return List.of();
    }

    @Override
    public List<Disciplina> getDisciplinasByInstituicao(DisciplinaByInstituicaoDTO dto) {
        return List.of();
    }

    @Override
    public Disciplina updateDisciplina(UpdateDisciplinaDTO dto) {
        return null;
    }

    @Override
    public DisciplinaEstudantesDTO addEstudanteToDisciplina(DisciplinaByEstudanteDTO dto) {
        return null;
    }

    @Override
    public DisciplinaEstudantesDTO removeEstudanteFromDisciplina(DisciplinaByEstudanteDTO dto) {
        return null;
    }

    @Override
    public DisciplinaEstudantesDTO enrollByBulk(EstudantesByBulkDTO dto) {
        return null;
    }

    @Override
    public DisciplinaEstudantesDTO unenrollByBulk(EstudantesByBulkDTO dto) {
        return null;
    }
}
