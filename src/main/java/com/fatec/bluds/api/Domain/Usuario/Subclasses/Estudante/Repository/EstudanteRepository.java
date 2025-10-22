package com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Repository;

import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}

@Query("""
    SELECT new com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.DTO.EstudanteListDTO(
        e.id, e.nome, e.email, e.matricula, e.anoEscolar, e.periodo
    )
    FROM Estudante e
    WHERE (:anoEscolar IS NULL OR e.anoEscolar = :anoEscolar)
      AND (:periodo IS NULL OR e.periodo = :periodo)
      AND (:nome IS NULL OR LOWER(e.nome) LIKE LOWER(CONCAT('%', :nome, '%')))
""")
List<EstudanteListDTO> listarEstudantes(
    @Param("anoEscolar") AnoEscolar anoEscolar,
    @Param("periodo") Periodo periodo,
    @Param("nome") String nome
);

