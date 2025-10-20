package com.fatec.bluds.api.Domain.Disciplina.Controller;

import com.fatec.bluds.api.Domain.Disciplina.DTO.AlunoResumoDTO;
import com.fatec.bluds.api.Domain.Disciplina.Service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    @GetMapping("/{id}/alunos")
    public ResponseEntity<List<AlunoResumoDTO>> listarAlunos(@PathVariable Long id) {
        List<AlunoResumoDTO> alunos = service.listarAlunosPorDisciplina(id);
        return ResponseEntity.ok(alunos);
    }
}
