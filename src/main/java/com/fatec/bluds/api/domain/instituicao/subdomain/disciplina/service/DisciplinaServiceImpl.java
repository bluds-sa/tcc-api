package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.service;

import com.fatec.bluds.api.domain.instituicao.model.InstituicaoEnsino;
import com.fatec.bluds.api.domain.instituicao.service.InstituicaoService;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.*;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.repository.DisciplinaRepository;
import com.fatec.bluds.api.domain.usuario.subclasses.educador.model.Educador;
import com.fatec.bluds.api.domain.usuario.subclasses.educador.service.EducadorService;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.model.Estudante;
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
        InstituicaoEnsino instituicaoEnsino = instituicaoService.getInstituicaoById(dto.idInstituicao());
        Educador educador = educadorService.findById(dto.idEducadorResponsavel());

        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.nome());
        disciplina.setDescricao(dto.descricao());
        disciplina.setEducador(educador);
        disciplina.setInstituicaoEnsino(instituicaoEnsino);

        return disciplinaRepository.save(disciplina);
    }

    @Override
    public List<Disciplina> getDisciplinasByEstudante(DisciplinaByEstudanteDTO dto) {
        if (dto.estudanteId() == null || dto.estudanteId() <= 0) {
            throw new IllegalArgumentException("ID de Estudante deve ser maior que zero");
        }

        List<Disciplina> disciplinas = disciplinaRepository.findByEstudanteId(dto.estudanteId());

        return disciplinas;
    }

    @Override
    public List<Disciplina> getDisciplinasByInstituicao(DisciplinaByInstituicaoDTO dto) {
        if (dto.instituicaoId() == null || dto.instituicaoId() <= 0) {
            throw new IllegalArgumentException("ID da Instituição de Ensino deve ser maior que zero");
        }

        return disciplinaRepository.findByInstituicaoEnsinoId(dto.instituicaoId());
    }

    @Override
    public Disciplina updateDisciplina(UpdateDisciplinaDTO dto) {
        return null;
    }

    @Override
    public List<Estudante> getEstudantesFromDisciplina(Long id) {
        return List.of();
    }

    @Override
    public List<Estudante> addEstudanteToDisciplina(DisciplinaByEstudanteDTO dto) {
        return null;
    }

    @Override
    public List<Estudante> removeEstudanteFromDisciplina(DisciplinaByEstudanteDTO dto) {
        return null;
    }

    @Override
    public List<Estudante> enrollByBulk(EstudantesByBulkDTO dto) {
        return null;
    }

    @Override
    public List<Estudante> unenrollByBulk(EstudantesByBulkDTO dto) {
        return null;
    }
}
