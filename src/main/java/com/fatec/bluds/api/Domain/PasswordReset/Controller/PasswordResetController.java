package com.fatec.bluds.api.Domain.PasswordReset.Controller;

import com.fatec.bluds.api.Domain.PasswordReset.DTO.PasswordResetDTO;
import com.fatec.bluds.api.Domain.PasswordReset.Service.PasswordResetService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reset-password")
public class PasswordResetController {

    @Autowired
    private PasswordResetService passwordResetService;

    @PostMapping("/forgot-password")
    public ResponseEntity<Object> forgotPassword(@RequestBody @Valid PasswordResetDTO dto) throws MessagingException {
        passwordResetService.processRequest(dto);

        return ResponseEntity.ok().body("Se o e-mail estiver cadastrado, você receberá instruções de redefinição de senha.");
    }

    @PostMapping("/validate/{token}")
    public ResponseEntity<Object> validateToken(@PathVariable String token) {
        if (passwordResetService.validateToken(token)) {
            return ResponseEntity.badRequest().body("Token é inválida.");
        } else {
            return ResponseEntity.ok().body("Token é válida.");
        }
    }
}
