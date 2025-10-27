package com.fatec.bluds.api.domain.instituicao.controller;

import com.fatec.bluds.api.domain.instituicao.dto.CreateInstituicaoDTO;
import com.fatec.bluds.api.domain.instituicao.dto.InstituicaoDetailsDTO;
import com.fatec.bluds.api.domain.instituicao.dto.InstituicaoMembersDTO;
import com.fatec.bluds.api.domain.instituicao.dto.UpdateInstituicaoDTO;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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
            @ApiResponse(responseCode = "201", description = "Instituição de Ensino criada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados inválidos ou ausentes"),
            @ApiResponse(responseCode = "409", description = "Email ou CNPJ já cadastrados")
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

    @Operation(summary = "Obtém um Instituição de Ensino através do seu ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instituição de Ensino encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Instituição de Ensino não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Object> getInstituicaoById(@PathVariable Long id) {
        InstituicaoEnsino instituicao = instituicaoService.getInstituicaoById(id);

        return ResponseEntity.ok(new InstituicaoDetailsDTO(instituicao));
    }

    @Operation(summary = "Obtém uma lista com as instituições de ensino cadastradas no sistema", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhuma instituição encontrada")
    })
    @GetMapping
    public ResponseEntity<List<InstituicaoDetailsDTO>> getInstituicoes() {

        return ResponseEntity.ok(instituicaoService.getInstituicoes());
    }

    @Operation(summary = "Atualiza as informações de uma Instituição de Ensino", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização concluída"),
            @ApiResponse(responseCode = "422", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Instituição não encontrada"),
    })
    @PreAuthorize("hasRole('GESTOR')")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateInstituicao(@RequestBody @Valid UpdateInstituicaoDTO dto, @PathVariable Long id) {
        InstituicaoEnsino instituicao = instituicaoService.updateInstituicao(id, dto);

        return ResponseEntity.ok().body(new InstituicaoDetailsDTO(instituicao));
    }

    @Operation(summary = "Lista os usuários membros de uma determinada Instituição de Ensino", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados listados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Instituição não encontrada")
    })
    @GetMapping("/{instituicaoId}/usuarios")
    public ResponseEntity<Object> getUsuariosFromInstituicao(@PathVariable Long instituicaoId) {
        InstituicaoEnsino instituicaoEnsino = instituicaoService.getInstituicaoById(instituicaoId);

        return ResponseEntity.ok(new InstituicaoMembersDTO(instituicaoEnsino));
    }

    @Operation(summary = "Adiciona Usuário a uma Instituição de Ensino", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário adicionado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Instituição ou Usuário não encontrados"),
            @ApiResponse(responseCode = "409", description = "Usuário já vinculado a uma Instituição de Ensino")
    })
    @PostMapping("/{instituicaoId}/usuarios/{usuarioId}")
    public ResponseEntity<Object> addUsuarioToInstituicao(@PathVariable Long instituicaoId, @PathVariable Long usuarioId) {

        InstituicaoEnsino instituicao = instituicaoService
                .addUsuarioToInstituicao(instituicaoId, usuarioId);

        return ResponseEntity.ok(new InstituicaoMembersDTO(instituicao));
    }

    @Operation(summary = "Remove Usuário de uma Instituição de Ensino", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário removidos com sucesso"),
            @ApiResponse(responseCode = "404", description = "Instituição ou Usuário não encontrados"),
            @ApiResponse(responseCode = "409", description = "Usuário não está associado a Instituição de Ensino")
    })
    @DeleteMapping("/{instituicaoId}/usuarios/{usuarioId}")
    public ResponseEntity<Object> removeUsuarioFromInstituicao(@PathVariable Long instituicaoId, @PathVariable Long usuarioId) {
        InstituicaoEnsino instituicao = instituicaoService
                .removeUsuarioFromInstituicao(instituicaoId, usuarioId);

        return ResponseEntity.ok(new InstituicaoMembersDTO(instituicao));
    }
}
