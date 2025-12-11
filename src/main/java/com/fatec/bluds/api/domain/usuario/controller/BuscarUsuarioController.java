package com.fatec.bluds.api.domain.usuario.controller;

import com.fatec.bluds.api.domain.usuario.dto.UsuarioDetailsDTO;
import com.fatec.bluds.api.domain.usuario.model.Usuario;
import com.fatec.bluds.api.domain.usuario.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Busca de Usuários", description = "Responsável por operações relacionadas a buscas de usuários")
public class BuscarUsuarioController {

    private final UsuarioService service;

    public BuscarUsuarioController(UsuarioService service) {
        this.service = service;
    }

    @Operation(summary = "Busca um usuário com base no seu ID")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDetailsDTO> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = service.getUsuarioById(id).orElse(null);

        return usuario == null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(new UsuarioDetailsDTO(usuario));
    }

    // 🔥 NOVO ENDPOINT: GET /usuarios
    @Operation(summary = "Busca todos os usuários")
    @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso")
    @ApiResponse(responseCode = "204", description = "Nenhum usuário encontrado")
    @GetMapping
    public ResponseEntity<List<UsuarioDetailsDTO>> getAllUsuarios() {
        List<Usuario> usuarios = service.getAllUsuarios();

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<UsuarioDetailsDTO> dtos = usuarios.stream()
                .map(UsuarioDetailsDTO::new) // usa o mesmo DTO do getById
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }
}
