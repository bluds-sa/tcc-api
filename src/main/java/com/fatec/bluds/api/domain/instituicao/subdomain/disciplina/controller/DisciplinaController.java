package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.controller;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.CreateDisciplinaDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.DisciplinaByEstudanteDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.DisciplinaByInstituicaoDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.DisciplinaSummaryDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.service.DisciplinaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@Tag(name = "Módulo Disciplinas", description = "Responsável por operações relacionadas a Disciplinas dentro de uma Instiuição de Ensino")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<Object> createDisciplina(@RequestBody @Valid CreateDisciplinaDTO dto) {
        return ResponseEntity.ok(new DisciplinaSummaryDTO(disciplinaService.createDisciplina(dto)));
    }

    @GetMapping
    public ResponseEntity<Object> getDisciplinasByEstudante(@RequestBody @Valid DisciplinaByEstudanteDTO dto) {
        List<DisciplinaSummaryDTO> disciplinas = disciplinaService
                .getDisciplinasByEstudante(dto)
                .stream().map(DisciplinaSummaryDTO::new)
                .toList();

        return ResponseEntity.ok(disciplinas);
    }

    @GetMapping
    public ResponseEntity<Object> getDisciplinasByInstituicao(@RequestBody @Valid DisciplinaByInstituicaoDTO dto) {
        List<DisciplinaSummaryDTO> disciplinas = disciplinaService
                .getDisciplinasByInstituicao(dto)
                .stream().map(DisciplinaSummaryDTO::new)
                .toList();

        return ResponseEntity.ok(disciplinas);
    }


}
