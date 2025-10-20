package com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Repository;

import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
