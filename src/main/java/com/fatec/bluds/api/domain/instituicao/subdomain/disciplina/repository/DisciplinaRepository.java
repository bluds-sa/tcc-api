package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.repository;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    @Query("SELECT d FROM Disciplina d JOIN d.estuandantes e WHERE e.id = :estudanteId")
    List<Disciplina> findByEstudanteId(@Param("estudanteId") Long estudanteId);
}
