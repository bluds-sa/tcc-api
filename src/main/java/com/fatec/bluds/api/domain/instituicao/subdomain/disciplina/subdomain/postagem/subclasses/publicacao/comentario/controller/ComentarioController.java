package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.controller;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.dto.ComentarioSummaryDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.dto.CreateComentarioDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.dto.UpdateComentarioDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.model.Comentario;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.service.ComentarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
@Tag(name = "Módulo Comentários", description = "Responsável por operações relacionadas a Comentários dentro de uma Publicação")
public class ComentarioController {

    private final ComentarioService service;

    public ComentarioController(ComentarioService service) {
        this.service = service;
    }

    @PostMapping("/responder/publicacao")
    public ResponseEntity<Object> responderPublicacao(
            @RequestParam
            @NotNull
            @Positive
            Long publicacaoId,
            @RequestBody
            @Valid
            CreateComentarioDTO dto,
            UriComponentsBuilder uriBuilder
    ) {
        Comentario comentario = service.responderPublicacao(publicacaoId, dto);

        var uri = uriBuilder
                .path("/comentarios/{id}")
                .buildAndExpand(comentario.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new ComentarioSummaryDTO(comentario));
    }

    @PostMapping("/responder/comentario")
    public ResponseEntity<Object> responderComentario(
            @RequestParam
            @NotNull
            @Positive
            Long comentarioId,
            @RequestBody
            @Valid
            CreateComentarioDTO dto
    ) {
        Comentario comentario = service.responderComentario(comentarioId, dto);

        return ResponseEntity.ok(new ComentarioSummaryDTO(comentario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getComentarioById(@PathVariable Long id) {
        Comentario comentario = service.getComentarioById(id);

        return ResponseEntity.ok(new ComentarioSummaryDTO(comentario));
    }

    @GetMapping("/publicacao")
    public ResponseEntity<Object> obterComentariosDaPublicacao(
            @RequestParam
            @NotNull
            @Positive
            Long publicacaoId
    ) {
        List<Comentario> comentarios = service.listarComentariosDePublicacao(publicacaoId);

        return comentarios.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(comentarios.stream().map(ComentarioSummaryDTO::new).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarComentario(@PathVariable Long id, @RequestBody UpdateComentarioDTO dto) {
        Comentario comentario = service.atualizarComentario(id, dto);

        return ResponseEntity.ok(new ComentarioSummaryDTO(comentario));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removerComentario(@PathVariable Long id) {
        service.removerComentario(id);

        return ResponseEntity.noContent().build();
    }
}
