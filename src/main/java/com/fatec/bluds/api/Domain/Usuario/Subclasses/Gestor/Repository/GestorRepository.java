package com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.Repository;


import com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.Gestor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GestorRepository extends JpaRepository<Gestor, Long> {

    Optional<Gestor> findByEmail(String email);
}
