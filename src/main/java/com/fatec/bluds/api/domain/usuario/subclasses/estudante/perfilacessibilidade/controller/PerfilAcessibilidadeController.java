package com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.controller;

import com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.dto.CreatePerfilAcessibilidadeDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.dto.PerfilAcessibilidadeSummaryDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.dto.UpdatePerfilAcessibilidadeDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.model.PerfilAcessibilidade;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.service.PerfilAcessibilidadeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/acessibilidade")
@Tag(name = "Módulo Perfil de Acessibilidade", description = "Operações relacionadas ao Perfil de Acessibilidade atribuido a cada Estudante")
public class PerfilAcessibilidadeController {

    private final PerfilAcessibilidadeService service;

    public PerfilAcessibilidadeController(PerfilAcessibilidadeService service) {
        this.service = service;
    }

    @PostMapping("/estudante")
    public ResponseEntity<Object> createPerfilAcessibilidade(
            @RequestParam
            @Positive
            @NotNull
            Long estudanteId,
            @RequestBody
            @Valid
            CreatePerfilAcessibilidadeDTO dto,
            UriComponentsBuilder uriBuilder) {

        PerfilAcessibilidade perfilAcessibilidade = service.createPerfilAcessibilidade(estudanteId, dto);

        var uri = uriBuilder
                .path("/acessibilidade/{id}")
                .buildAndExpand(perfilAcessibilidade.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new PerfilAcessibilidadeSummaryDTO(perfilAcessibilidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPerfilById(@PathVariable Long id) {
        PerfilAcessibilidade perfilAcessibilidade = service.getById(id);

        return ResponseEntity.ok().body(new PerfilAcessibilidadeSummaryDTO(perfilAcessibilidade));
    }

    @GetMapping("/estudante/{id}")
    public ResponseEntity<Object> getPerfilByEstudanteId(@PathVariable Long id) {
        PerfilAcessibilidade perfilAcessibilidade = service.getByEstudante(id);

        return ResponseEntity.ok().body(new PerfilAcessibilidadeSummaryDTO(perfilAcessibilidade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePerfilAcessibilidade(@PathVariable Long id, @RequestBody UpdatePerfilAcessibilidadeDTO dto) {
        PerfilAcessibilidade perfilAcessibilidade = service.updatePerfilAcessibilidade(id, dto);

        return ResponseEntity.ok().body(new PerfilAcessibilidadeSummaryDTO(perfilAcessibilidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removePerfilAcessibilidade(@PathVariable Long id) {
        service.removePerfilAcessibilidade(id);

        return ResponseEntity.noContent().build();
    }
}
