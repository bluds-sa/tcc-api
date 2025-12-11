package com.fatec.bluds.api.domain.usuario.service;

import com.fatec.bluds.api.domain.usuario.model.Usuario;
import com.fatec.bluds.api.domain.usuario.repository.UsuarioRepository;
import com.fatec.bluds.api.infra.exceptions.usuario.UsuarioNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario getAuthenticatedUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UsuarioNotFoundException("Usuário não autenticado");
        }

        String email = authentication.getName();

        return repository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário autenticado não encontrado"));
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return repository.findById(id);
    }

    // ✅ NOVO MÉTODO: retorna todos os usuários
    public List<Usuario> getAllUsuarios() {
        return repository.findAll();
    }
}
