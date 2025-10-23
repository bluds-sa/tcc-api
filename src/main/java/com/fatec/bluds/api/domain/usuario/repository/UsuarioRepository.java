package com.fatec.bluds.api.domain.usuario.repository;

import com.fatec.bluds.api.domain.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findUserDetailsByEmail(String email);

    Optional<Usuario> findByEmail(String email);
}
