package com.fatec.bluds.api.Domain.Usuario.Controller;

import com.fatec.bluds.api.Domain.Usuario.DTO.AuthenticationDTO;
import com.fatec.bluds.api.Domain.Usuario.Service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AuthenticationDTO dto) {

        var auth = this.authenticationService.authenticate(dto);

        return ResponseEntity.ok().build();
    }
}
