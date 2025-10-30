package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.repository;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
