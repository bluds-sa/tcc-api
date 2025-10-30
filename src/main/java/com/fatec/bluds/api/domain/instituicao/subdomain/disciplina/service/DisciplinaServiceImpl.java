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
import com.fatec.bluds.api.infra.exceptions.disciplina.DisciplinaNotFoundException;
import jakarta.transaction.Transactional;
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
    public Disciplina getDisciplinaById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID da Disciplina não pode ser nulo ou inferior a 1");
        }

        return disciplinaRepository.findById(id).orElseThrow(
                () -> new DisciplinaNotFoundException("Disciplina com ID " + id + " não encontrada")
        );
    }

    @Override
    public List<Disciplina> getDisciplinasByEstudante(Long estudanteId) {
        return disciplinaRepository.findByEstudanteId(estudanteId);
    }

    @Override
    public List<Disciplina> getDisciplinasByInstituicao(Long instituicaoId) {
        return List.of();
    }

    @Override
    public List<Disciplina> getDisciplinasByEducador(Long educadorId) {
        return List.of();
    }

    @Transactional
    @Override
    public Disciplina updateDisciplina(Long id, UpdateDisciplinaDTO dto) {
        Disciplina disciplina = this.getDisciplinaById(id);

        if (dto.nome() != null && !dto.nome().isBlank()) {
            disciplina.setNome(dto.nome());
        }

        if (dto.descricao() != null && !dto.descricao().isBlank()) {
            disciplina.setDescricao(dto.descricao());
        }

        if (dto.idEducadorResponsavel() != null && dto.idEducadorResponsavel() > 0) {
            Educador educador = educadorService.findById(dto.idEducadorResponsavel());
            disciplina.setEducador(educador);
        }

        return disciplinaRepository.save(disciplina);
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
