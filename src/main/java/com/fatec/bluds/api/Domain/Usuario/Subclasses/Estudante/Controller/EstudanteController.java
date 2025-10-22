package com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Controller;

import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.DTO.EstudanteUpdateDTO;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Estudante;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Service.EstudanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService service;

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid EstudanteUpdateDTO dto
    ) {
        Estudante atualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudanteResponseDTO> buscarPorId(@PathVariable Long id) {
    var estudante = service.buscarPorId(id);
    return ResponseEntity.ok(estudante);
    }

    @GetMapping
    public ResponseEntity<List<EstudanteListDTO>> listar(
            @RequestParam(required = false) AnoEscolar anoEscolar,
            @RequestParam(required = false) Periodo periodo,
            @RequestParam(required = false) String nome
    ) {
        var estudantes = service.listar(anoEscolar, periodo, nome);
        return ResponseEntity.ok(estudantes);
    }


}
