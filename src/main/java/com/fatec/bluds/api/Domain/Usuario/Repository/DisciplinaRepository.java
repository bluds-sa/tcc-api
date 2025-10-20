package com.fatec.bluds.api.Domain.Disciplina.Repository;

import com.fatec.bluds.api.Domain.Disciplina.Disciplina;
import com.fatec.bluds.api.Domain.Disciplina.DTO.AlunoResumoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    Optional<Disciplina> findById(Long id);

    // Busca os alunos vinculados à disciplina
    @Query("""
        SELECT new com.fatec.bluds.api.Domain.Disciplina.DTO.AlunoResumoDTO(
            e.id, e.nome, e.email, 'ALUNO'
        )
        FROM Disciplina d
        JOIN d.estudantes e
        WHERE d.id = :id
    """)
    List<AlunoResumoDTO> listarAlunosPorDisciplina(Long id);
}
