package com.fatec.bluds.api.Domain.Usuario.Service;

import com.fatec.bluds.api.Domain.Usuario.DTO.PasswordUpdateDTO;
import com.fatec.bluds.api.Domain.Usuario.DTO.ResetPasswordRequestDTO;
import com.fatec.bluds.api.Domain.Usuario.Entity.PasswordResetToken;
import com.fatec.bluds.api.Domain.Usuario.Repository.PasswordResetTokenRepository;
import com.fatec.bluds.api.Domain.Usuario.Repository.UsuarioRepository;
import com.fatec.bluds.api.Domain.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PasswordResetService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Expiração padrão: 15 minutos
    private static final long TOKEN_EXPIRATION_MINUTES = 15;

    public void requestReset(ResetPasswordRequestDTO dto) {
        // Mesmo se o e-mail não existir, retornamos 200 (não revelar a existência do e-mail real)
        usuarioRepository.findUserDetailsByEmail(dto.email())
                .ifPresent(u -> {
                    tokenRepository.deleteByEmail(dto.email());
                    String token = UUID.randomUUID().toString();
                    LocalDateTime expiration = LocalDateTime.now().plusMinutes(TOKEN_EXPIRATION_MINUTES);
                    tokenRepository.save(new PasswordResetToken(dto.email(), token, expiration));

                    // Aqui poderia enviar e-mail real
                    System.out.println("🔗 Token de redefinição: " + token);
                });
    }

    public void validateToken(String token) {
        var tokenOpt = tokenRepository.findByToken(token)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token inválido"));
        if (tokenOpt.isExpired()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token expirado");
        }
    }

    public void resetPassword(PasswordUpdateDTO dto) {
        var tokenOpt = tokenRepository.findByToken(dto.token())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token inválido"));

        if (tokenOpt.isExpired()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token expirado");
        }

        Usuario usuario = usuarioRepository.findUserDetailsByEmail(tokenOpt.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        usuario.setSenha(encoder.encode(dto.password()));
        usuarioRepository.save(usuario);

        tokenRepository.deleteByEmail(tokenOpt.getEmail());
    }
}
