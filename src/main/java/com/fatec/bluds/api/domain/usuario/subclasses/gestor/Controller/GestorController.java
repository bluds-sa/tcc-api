package com.fatec.bluds.api.domain.usuario.subclasses.gestor.Controller;

import com.fatec.bluds.api.domain.usuario.subclasses.gestor.DTO.GestorDetailsDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.gestor.DTO.GestorGetByEmailDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.gestor.DTO.UpdateGestorDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.gestor.Gestor;
import com.fatec.bluds.api.domain.usuario.subclasses.gestor.Service.GestorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestor")
@Tag(name = "Módulo de Gestores", description = "Lida com operações relacionadas à classe Gestor")
public class GestorController {

    @Autowired
    private GestorService service;

    @Operation(summary = "Obtém um Gestor de acordo com seu ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",  description = "Gestor obtido com sucesso"),
            @ApiResponse(responseCode = "400",  description = "Ocorreu erro durante o processamento da requsição"),
            @ApiResponse(responseCode = "404",  description = "Não foi possível obter o Gestor com o ID especificado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Object> getGestorById(@PathVariable Long id) {
        Gestor gestor = service.getGestorById(id);

        return ResponseEntity.ok(new GestorDetailsDTO(gestor));
    }

    @Operation(summary = "Obtém um Gestor de acordo com seu e-mail", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",  description = "Gestor obtido com sucesso"),
            @ApiResponse(responseCode = "400",  description = "Ocorreu erro durante o processamento da requsição"),
            @ApiResponse(responseCode = "404",  description = "Não foi possível obter o Gestor com o ID especificado")
    })
    @GetMapping
    public ResponseEntity<Object> getGestorByEmail(@RequestBody @Valid GestorGetByEmailDTO dto) {
        Gestor gestor = service.getGestorByEmail(dto);

        return ResponseEntity.ok(new GestorDetailsDTO(gestor));
    }

    @Operation(summary = "Atualiza as informações de um Gestor", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",  description = "Gestor obtido com sucesso"),
            @ApiResponse(responseCode = "400",  description = "Ocorreu erro durante o processamento da requsição"),
            @ApiResponse(responseCode = "404",  description = "Não foi possível obter o Gestor com o ID especificado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGestor(@RequestBody @Valid UpdateGestorDTO dto, @PathVariable Long id) {

        Gestor gestor = service.getGestorById(id);

        service.updateGestor(gestor, dto);

        return ResponseEntity.ok(new GestorDetailsDTO(gestor));
    }

    /*
     TODO: Exclusão de Gestores deve ser lógica (apenas colocamos isActivated = false)
      e não pode ser realizada ser o gestor for o único vinculado a sua Instituição de Ensino
     */
}
