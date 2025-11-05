package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.arquivo.controller;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.arquivo.dto.ArquivoDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.arquivo.model.Arquivo;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.arquivo.service.ArquivoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/disciplinas/{disciplinaId}/arquivos")
public class ArquivoController {

    private final ArquivoService arquivoService;

    public ArquivoController(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }

    @Operation(summary = "Faz upload de um arquivo para uma disciplina", method = "POST")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Arquivo enviado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Disciplina ou Educador não encontrados"),
            @ApiResponse(responseCode = "400", description = "Falha ao enviar o arquivo")
    })
    @PostMapping
    public ResponseEntity<ArquivoDTO> uploadArquivo(
            @PathVariable
            @NotNull(message = "ID da disciplina é obrigatório")
            @Positive(message = "ID da disciplina deve ser positivo")
            Long disciplinaId,
            @RequestParam("educadorId")
            @NotNull(message = "ID do educador é obrigatório")
            @Positive(message = "ID do educador deve ser positivo")
            Long educadorId,
            @RequestParam("arquivo") MultipartFile arquivo
    ) {
        Arquivo novo = arquivoService.uploadArquivo(disciplinaId, educadorId, arquivo);
        ArquivoDTO dto = new ArquivoDTO(
                novo.getId(),
                novo.getNome(),
                novo.getCaminho(),
                novo.getDataEnvio(),
                novo.getEnviadoPor().getNome()
        );
        return ResponseEntity.status(201).body(dto);
    }

    @Operation(summary = "Lista todos os arquivos de uma disciplina", method = "GET")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Arquivos listados com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhum arquivo encontrado")
    })
    @GetMapping
    public ResponseEntity<List<ArquivoDTO>> listarArquivos(
            @PathVariable
            @NotNull @Positive Long disciplinaId
    ) {
        List<ArquivoDTO> arquivos = arquivoService.listarArquivos(disciplinaId);
        if (arquivos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(arquivos);
    }
}
