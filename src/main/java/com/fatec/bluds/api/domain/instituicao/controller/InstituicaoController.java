package com.fatec.bluds.api.domain.instituicao.controller;

import com.fatec.bluds.api.domain.instituicao.dto.CreateInstituicaoDTO;
import com.fatec.bluds.api.domain.instituicao.dto.InstituicaoDetailsDTO;
import com.fatec.bluds.api.domain.instituicao.model.InstituicaoEnsino;
import com.fatec.bluds.api.domain.instituicao.service.InstituicaoService;
import com.fatec.bluds.api.domain.usuario.service.UsuarioService;
import com.fatec.bluds.api.domain.usuario.subclasses.Gestor.Gestor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/instituicao")
@Tag(name = "Módulo Instituições de Ensino", description = "Gerencia as operações envolvendo instituições de ensino")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Realiza a criação de instituições, vinculando automaticamente o Gestor que realizou a solicitação", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",  description = "Instituição de Ensino criada com sucesso"),
            @ApiResponse(responseCode = "422",  description = "Dados inválidos ou ausentes"),
            @ApiResponse(responseCode = "409",  description = "Email ou CNPJ já cadastrados")
    })
    @PreAuthorize("hasRole('GESTOR')")
    @PostMapping
    public ResponseEntity<Object> createInstituicao(@RequestBody @Valid CreateInstituicaoDTO dto, UriComponentsBuilder uriBuilder) {

        Gestor gestorAutenticado = (Gestor) usuarioService.getAuthenticatedUser();

        InstituicaoEnsino instituicaoEnsino = instituicaoService.createInstituicao(dto, gestorAutenticado);

        var uri = uriBuilder
                .path("/instituicao/{id}")
                .buildAndExpand(instituicaoEnsino.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new InstituicaoDetailsDTO(instituicaoEnsino));
    }
}
