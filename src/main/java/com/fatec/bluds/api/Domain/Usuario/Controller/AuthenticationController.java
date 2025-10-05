package com.fatec.bluds.api.Domain.Usuario.Controller;

import com.fatec.bluds.api.Domain.Usuario.DTO.*;
import com.fatec.bluds.api.Domain.Usuario.Service.AuthenticationService;
import com.fatec.bluds.api.Domain.Usuario.Usuario;
import com.fatec.bluds.api.Infra.Security.Token.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AuthenticationDTO dto) {

        var auth = this.authenticationService.authenticate(dto, authenticationManager);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token, new UsuarioDetailsDTO((Usuario) auth.getPrincipal())));
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterDTO dto, UriComponentsBuilder uriBuilder) {
        Usuario usuario = authenticationService.register(dto);

        var uri = uriBuilder
                .path("/user/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new UsuarioDetailsDTO(usuario));
    }
}
