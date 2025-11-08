package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.controller;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.dto.CreatePublicacaoDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.dto.PublicacaoDetailsDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.dto.PublicacaoSummaryDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.dto.UpdatePublicacaoDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.model.Publicacao;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.service.PublicacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicacoes")
@Tag(name = "Módulo Publicações", description = "Responsável por operações relacionadas a Publicações dentro de uma Disciplina")
public class PublicacaoController {

    private final PublicacaoService publicacaoService;

    public PublicacaoController(PublicacaoService publicacaoService) {
        this.publicacaoService = publicacaoService;
    }

    @Operation(summary = "Cria uma Publicação", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Publicação criada com sucesso"),
            @ApiResponse(responseCode = "403", description = "O Educador que está realizando a Publicação não é o responsável pela Disciplina"),
            @ApiResponse(responseCode = "404", description = "Disciplina não encontrada"),
            @ApiResponse(responseCode = "409", description = "Dados inválidos ou conflitantes")
    })
    @PreAuthorize("hasRole('EDUCADOR')")
    @PostMapping
    public ResponseEntity<Object> createPublicacao(@RequestBody @Valid CreatePublicacaoDTO dto) {
        Publicacao publicacao = publicacaoService.createPublicacao(dto);

        return ResponseEntity.ok().body(new PublicacaoSummaryDTO(publicacao));
    }

    @GetMapping("/disciplina")
    public ResponseEntity<Object> getPublicacoes(
            @RequestParam
            @NotNull(message = "ID da Disciplina não pode ser nulo")
            @Positive(message = "ID da Disciplina não pode ser negativo ou zero")
            Long discplinaId
    ) {
        List<Publicacao> publicacoes = publicacaoService.getPublicacoesByDisciplina(discplinaId);

        return publicacoes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(
                publicacoes.stream().map(PublicacaoDetailsDTO::new).toList()
        );
    }

    @GetMapping("/{publicacaoId}")
    public ResponseEntity<Object> getPublicacao(@PathVariable Long publicacaoId) {
        Publicacao publicacao = publicacaoService.getPublicacaoById(publicacaoId);

        return ResponseEntity.ok().body(new PublicacaoDetailsDTO(publicacao));
    }

    @PreAuthorize("hasRole('EDUCADOR')")
    @PutMapping("/{publicacaoId}")
    public ResponseEntity<Object> updatePublicacao(@PathVariable Long publicacaoId, @RequestBody UpdatePublicacaoDTO dto) {
        Publicacao publicacao = publicacaoService.updatePublicacao(publicacaoId, dto);

        return ResponseEntity.ok().body(new PublicacaoDetailsDTO(publicacao));
    }

    @PreAuthorize("hasRole('EDUCADOR')")
    @DeleteMapping("/{publicacaoId}")
    public ResponseEntity<Object> deletePublicacao(@PathVariable Long publicacaoId) {
        publicacaoService.removePublicacao(publicacaoId);

        return ResponseEntity.noContent().build();
    }
}
