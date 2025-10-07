package com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.Controller;

import com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.DTO.GestorDetailsDTO;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.DTO.GestorGetByEmailDTO;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.Gestor;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.Service.GestorService;
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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getGestorById(@PathVariable Long id) {
        Gestor gestor = service.getGestorById(id);

        return ResponseEntity.ok(new GestorDetailsDTO(gestor));
    }

    @GetMapping
    public ResponseEntity<Object> getGestorByEmail(@RequestBody @Valid GestorGetByEmailDTO dto) {
        Gestor gestor = service.getGestorByEmail(dto);

        return ResponseEntity.ok(new GestorDetailsDTO(gestor));
    }


}
