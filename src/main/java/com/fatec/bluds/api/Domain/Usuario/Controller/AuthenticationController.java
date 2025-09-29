package com.fatec.bluds.api.Domain.Usuario.Controller;

import com.fatec.bluds.api.Domain.Usuario.DTO.AuthenticationDTO;
import com.fatec.bluds.api.Domain.Usuario.DTO.RegisterDTO;
import com.fatec.bluds.api.Domain.Usuario.DTO.UsuarioDetailsDTO;
import com.fatec.bluds.api.Domain.Usuario.Service.AuthenticationService;
import com.fatec.bluds.api.Domain.Usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AuthenticationDTO dto) {

        var auth = this.authenticationService.authenticate(dto, authenticationManager);

        return ResponseEntity.ok().build();
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
