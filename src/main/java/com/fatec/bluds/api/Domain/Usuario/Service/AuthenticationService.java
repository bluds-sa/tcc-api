package com.fatec.bluds.api.Domain.Usuario.Service;

import com.fatec.bluds.api.Domain.Usuario.DTO.AuthenticationDTO;
import com.fatec.bluds.api.Domain.Usuario.DTO.RegisterDTO;
import com.fatec.bluds.api.Domain.Usuario.Factory.UserFactory;
import com.fatec.bluds.api.Domain.Usuario.Repository.UsuarioRepository;
import com.fatec.bluds.api.Domain.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }

    public Authentication authenticate(AuthenticationDTO dto, AuthenticationManager authenticationManager) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());

        return authenticationManager.authenticate(usernamePassword);
    }

    public Usuario register(RegisterDTO dto) {
        if (this.repository.findByEmail(dto.email()) != null) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }

        Usuario usuario = UserFactory.createUser(dto);

        String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setSenha(encryptedPassword);

        return repository.save(usuario);
    }

}
