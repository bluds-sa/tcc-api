package com.fatec.bluds.api.Domain.Disciplina.Service;

import com.fatec.bluds.api.Domain.Disciplina.DTO.AlunoResumoDTO;
import com.fatec.bluds.api.Domain.Disciplina.Repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public List<AlunoResumoDTO> listarAlunosPorDisciplina(Long id) {
        var disciplinaOpt = repository.findById(id);

        if (disciplinaOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada");
        }

        List<AlunoResumoDTO> alunos = repository.listarAlunosPorDisciplina(id);

        if (alunos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhum aluno vinculado à disciplina");
        }

        return alunos;
    }
}
