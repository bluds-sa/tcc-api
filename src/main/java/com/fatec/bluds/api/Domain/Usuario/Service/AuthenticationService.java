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

    @Autowired
    private JwtTokenService jwtService;

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
    // Login
    public LoginResponseDTO login(LoginRequestDTO dto) {
        Usuario usuario = repository.findUserDetailsByEmail(dto.email());
        if (usuario == null || !encoder.matches(dto.senha(), usuario.getSenha()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais inválidas.");
        // Gerando o token de acordo com o arquivo "JwtTokenService"
        String access = jwtService.generateAccessToken(usuario.getEmail());
        String refresh = jwtService.generateRefreshToken(usuario.getEmail());

        validRefreshTokens.put(refresh, usuario.getEmail());

        return new LoginResponseDTO(access, refresh, "Bearer");
    }
    // Dar refresh no token, caso algo aconteça, como seu vencimento
    public LoginResponseDTO refreshToken(String refreshToken) {
        if (!jwtService.validateToken(refreshToken) || !validRefreshTokens.containsKey(refreshToken))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Refresh token inválido.");

        String email = jwtService.getEmailFromToken(refreshToken);
        String newAccess = jwtService.generateAccessToken(email);

        return new LoginResponseDTO(newAccess, refreshToken, "Bearer");
    }
    // Logout
    public void logout(String refreshToken) {
        validRefreshTokens.remove(refreshToken);
    }
}
