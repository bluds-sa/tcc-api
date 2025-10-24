package com.fatec.bluds.api.domain.usuario.subclasses.Estudante.Controller;

import com.fatec.bluds.api.domain.usuario.subclasses.Estudante.DTO.EstudanteListDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.Estudante.DTO.EstudanteResponseDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.Estudante.DTO.EstudanteSummaryDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.Estudante.DTO.EstudanteUpdateDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.Estudante.Enums.AnoEscolar;
import com.fatec.bluds.api.domain.usuario.subclasses.Estudante.Enums.Periodo;
import com.fatec.bluds.api.domain.usuario.subclasses.Estudante.Estudante;
import com.fatec.bluds.api.domain.usuario.subclasses.Estudante.Service.EstudanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService service;

    @PutMapping("/{id}")
    public ResponseEntity<EstudanteResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid EstudanteUpdateDTO dto
    ) {
        Estudante atualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(new EstudanteResponseDTO(atualizado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudanteSummaryDTO> buscarPorId(@PathVariable Long id) {
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

}
