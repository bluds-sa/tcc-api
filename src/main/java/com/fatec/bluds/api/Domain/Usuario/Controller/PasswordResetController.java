package com.fatec.bluds.api.Domain.Usuario.Controller;

import com.fatec.bluds.api.Domain.Usuario.DTO.PasswordUpdateDTO;
import com.fatec.bluds.api.Domain.Usuario.DTO.ResetPasswordRequestDTO;
import com.fatec.bluds.api.Domain.Usuario.Service.PasswordResetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reset-password")
public class PasswordResetController {

    @Autowired
    private PasswordResetService service;

    @PostMapping("/forgot-password")
    public ResponseEntity<Void> requestReset(@RequestBody @Valid ResetPasswordRequestDTO dto) {
        service.requestReset(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validate")
    public ResponseEntity<Void> validate(@RequestParam String token) {
        service.validateToken(token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> reset(@RequestBody @Valid PasswordUpdateDTO dto) {
        service.resetPassword(dto);
        return ResponseEntity.ok().build();
    }
}
