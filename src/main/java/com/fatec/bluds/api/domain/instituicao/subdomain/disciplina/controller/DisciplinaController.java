package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.controller;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.dto.*;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.service.DisciplinaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@Tag(name = "Módulo Disciplinas", description = "Responsável por operações relacionadas a Disciplinas dentro de uma Instiuição de Ensino")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<Object> createDisciplina(@RequestBody @Valid CreateDisciplinaDTO dto, UriComponentsBuilder uriBuilder) {

        Disciplina disciplina = disciplinaService.createDisciplina(dto);

        var uri = uriBuilder
                .path("/disciplinas/{id}")
                .buildAndExpand(disciplina.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new DisciplinaSummaryDTO(disciplina));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDisciplinaById(@PathVariable Long id) {
        return ResponseEntity.ok(disciplinaService.getDisciplinaById(id));
    }

    @GetMapping("/estudante")
    public ResponseEntity<Object> getDisciplinasByEstudante(
            @RequestParam
            @NotNull(message = "ID do Estudante não pode ser nulo")
            @Positive(message = "ID do  Estudante não pode ser negativo ou zero")
            Long estudanteId
    ) {

        List<Disciplina> disciplinas = disciplinaService.getDisciplinasByEstudante(estudanteId);

        return disciplinas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(
                disciplinas.stream().map(DisciplinaSummaryDTO::new).toList()
        );
    }

    @GetMapping("/instituicao")
    public ResponseEntity<Object> getDisciplinasByInstituicao(
            @RequestParam
            @NotNull(message = "ID da Instituição de Ensino não pode ser nulo")
            @Positive(message = "ID da Instituição de Ensino deve ser um número positivo maior que zero")
            Long instituicaoId
    ) {
        List<Disciplina> disciplinas = disciplinaService.getDisciplinasByInstituicao(instituicaoId);

        return disciplinas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(
                disciplinas.stream().map(DisciplinaSummaryDTO::new).toList()
        );
    }

    @GetMapping("/educador")
    public ResponseEntity<Object> getDisciplinasByEducador(
        @RequestParam
        @NotNull(message = "ID do Educador não pode ser nulo")
        @Positive(message = "ID do Educador deve ser um número positivo maior que zero")
        Long educadorId
    ) {
        List<Disciplina> disciplinas = disciplinaService.getDisciplinasByEducador(educadorId);

        return disciplinas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(
                disciplinas.stream().map(DisciplinaSummaryDTO::new).toList()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDisciplina(@PathVariable Long id, @RequestBody @Valid UpdateDisciplinaDTO dto) {
        DisciplinaSummaryDTO disciplinaSummary = new DisciplinaSummaryDTO(disciplinaService.updateDisciplina(id, dto));

        return ResponseEntity.ok(disciplinaSummary);
    }
}
