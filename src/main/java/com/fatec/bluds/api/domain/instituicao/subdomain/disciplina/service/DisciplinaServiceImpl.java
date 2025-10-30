package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.service;

import com.fatec.bluds.api.domain.instituicao.service.InstituicaoService;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.*;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.repository.DisciplinaRepository;
import com.fatec.bluds.api.domain.usuario.subclasses.educador.service.EducadorService;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaServiceImpl implements DisciplinaService{

    @Autowired
    private final DisciplinaRepository disciplinaRepository;

    @Autowired
    private final EducadorService educadorService;

    @Autowired
    private final EstudanteService estudanteService;

    @Autowired
    private final InstituicaoService instituicaoService;

    public DisciplinaServiceImpl(DisciplinaRepository disciplinaRepository,
                                 EducadorService educadorService,
                                 EstudanteService estudanteService,
                                 InstituicaoService instituicaoService) {
        this.disciplinaRepository = disciplinaRepository;
        this.educadorService = educadorService;
        this.estudanteService = estudanteService;
        this.instituicaoService = instituicaoService;
    }

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
