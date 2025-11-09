package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.controller;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.dto.CreateTarefaDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.dto.UpdateTarefaDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.model.Tarefa;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@Tag(name = "Módulo Tarefas", description = "Responsável por operações relacionadas a Tarefas dentro de uma Disciplina")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @Operation(summary = "Cria uma nova tarefa")
    @PostMapping
    @PreAuthorize("hasRole('EDUCADOR') or hasRole('GESTOR')")
    public ResponseEntity<Tarefa> createTarefa(
            @RequestBody @Valid CreateTarefaDTO dto,
            UriComponentsBuilder uriBuilder
    ) {
        Tarefa tarefa = tarefaService.createTarefa(dto);
        URI uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();
        return ResponseEntity.created(uri).body(tarefa);
    }

    @Operation(summary = "Busca uma tarefa pelo ID")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('EDUCADOR') or hasRole('GESTOR') or hasRole('ESTUDANTE')")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.getTarefaById(id);
        return ResponseEntity.ok(tarefa);
    }

    @Operation(summary = "Lista todas as tarefas de uma disciplina")
    @GetMapping("/disciplina/{disciplinaId}")
    @PreAuthorize("hasRole('EDUCADOR') or hasRole('GESTOR') or hasRole('ESTUDANTE')")
    public ResponseEntity<List<Tarefa>> getTarefasByDisciplina(@PathVariable Long disciplinaId) {
        List<Tarefa> tarefas = tarefaService.getTarefasByDisciplina(disciplinaId);
        return ResponseEntity.ok(tarefas);
    }

    @Operation(summary = "Atualiza uma tarefa existente")
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('EDUCADOR') or hasRole('GESTOR')")
    public ResponseEntity<Tarefa> updateTarefa(
            @PathVariable Long id,
            @RequestBody @Valid UpdateTarefaDTO dto
    ) {
        Tarefa updated = tarefaService.updateTarefa(id, dto);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Remove uma tarefa existente")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('EDUCADOR') or hasRole('GESTOR')")
    public ResponseEntity<Void> removeTarefa(@PathVariable Long id) {
        tarefaService.removeTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
