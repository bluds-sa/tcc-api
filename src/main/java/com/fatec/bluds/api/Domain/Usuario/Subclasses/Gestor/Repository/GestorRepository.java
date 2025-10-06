package com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.Repository;


import com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestorRepository extends JpaRepository<Gestor, Long> {

}
