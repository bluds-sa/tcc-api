package com.fatec.bluds.api.domain.usuario.subclasses.gestor.Repository;


import com.fatec.bluds.api.domain.usuario.subclasses.gestor.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GestorRepository extends JpaRepository<Gestor, Long> {

    Optional<Gestor> findByEmail(String email);
}
