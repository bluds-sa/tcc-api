package com.fatec.bluds.api.Domain.PasswordReset.Service;

import com.fatec.bluds.api.Domain.PasswordReset.DTO.PasswordResetDTO;
import com.fatec.bluds.api.Domain.PasswordReset.PasswordResetToken;
import com.fatec.bluds.api.Domain.PasswordReset.Repository.PasswordResetTokenRepository;
import com.fatec.bluds.api.Domain.Usuario.Repository.UsuarioRepository;
import com.fatec.bluds.api.Domain.Usuario.Usuario;
import com.fatec.bluds.api.Infra.Email.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

@Service
public class PasswordResetService {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder().withoutPadding();

    @Autowired
    private UsuarioRepository usuarioRepositoryrepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Value("${api.address}")
    private String appAdress;

    public void processRequest(PasswordResetDTO dto) throws MessagingException {
        Optional<Usuario> usuarioOptional = usuarioRepositoryrepository.findByEmail(dto.email());

        if (usuarioOptional.isEmpty()) return;

        Usuario usuario = usuarioOptional.get();
        String token = makePasswordResetToken();

        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setToken(token);
        passwordResetToken.setUsuario(usuario);
        passwordResetToken.setExpiresAt(LocalDateTime.now().plusMinutes(30));

        passwordResetTokenRepository.save(passwordResetToken);

        sendPasswordResetEmail(usuario, token);
    }

    public boolean validateToken(String token) {
        Optional<PasswordResetToken> optionalResetToken = passwordResetTokenRepository.findByToken(token);

        return optionalResetToken.isPresent() && !optionalResetToken.get().isExpired();
    }

    private String makePasswordResetToken() {
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);

        return base64Encoder.encodeToString(randomBytes);
    }

    private String buildResetLink(String token) {
        return appAdress + "/reset-password/validate/?token=" + token;
    }

    private void sendPasswordResetEmail(Usuario usuario, String token) throws MessagingException {
        Context context = new Context();
        context.setVariable("nome", usuario.getNome());
        context.setVariable("link", buildResetLink(token));

        String subject = "GIMAS | Redefinição de Senha";
        String body = templateEngine.process("email/password-reset-email.html", context);

        emailService.sendEmail(usuario.getEmail(), subject, body);
    }
}
