package com.fatec.bluds.api.Domain.Usuario.Service;

import com.fatec.bluds.api.Domain.Usuario.DTO.RegisterDTO;
import com.fatec.bluds.api.Domain.Usuario.Factory.UserFactory;
import com.fatec.bluds.api.Domain.Usuario.Repository.UsuarioRepository;
import com.fatec.bluds.api.Domain.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Service responsável por operações de autenticação (registro, login etc).
 */
@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository repository;

    // outros beans (jwt, auth manager, etc) já presentes no projeto podem permanecer

    /**
     * Registra um usuário novo.
     *
     * Regras aplicadas:
     * - Se e-mail já existente -> 409 Conflict (ResponseStatusException)
     * - Senha é codificada com BCrypt antes de persistir
     */
    public Usuario register(RegisterDTO dto) {
        // Ajuste: use um método que verifique se o e-mail já existe
        var existing = this.repository.findUserDetailsByEmail(dto.email());
        if (existing != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já cadastrado.");
        }

        // Cria a entidade (UserFactory deve construir a subclasse correta: Estudante/Educador/Gestor)
        Usuario usuario = UserFactory.createUser(dto);

        // Codificação de senha
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.senha());
        usuario.setSenha(encryptedPassword);

        // Salvando no repositório
        return repository.save(usuario);
    }
}
