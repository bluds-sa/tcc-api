package com.fatec.bluds.api.Domain.Usuario.Repository;

import com.fatec.bluds.api.Domain.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
