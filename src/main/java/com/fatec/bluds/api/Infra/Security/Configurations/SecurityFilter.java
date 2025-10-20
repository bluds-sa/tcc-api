package com.fatec.bluds.api.infra.security.configurations;

import com.fatec.bluds.api.domain.usuario.repository.UsuarioRepository;
import com.fatec.bluds.api.infra.security.token.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var token = recoverToken(request);

        if (token != null) {
            try {
                String login = tokenService.validateToken(token);

                if (login != null && !login.isBlank()) {
                    UserDetails usuario = usuarioRepository.findUserDetailsByEmail(login);

                    if (usuario != null) {
                        var authentication = new UsernamePasswordAuthenticationToken(
                                usuario,
                                null,
                                usuario.getAuthorities()
                        );
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    } else {
                        log.warn("Usuário não encontrado para o e-mail extraído do token: {}", login);
                    }
                } else {
                    log.warn("Token inválido ou sem subject (usuário).");
                }

            } catch (Exception e) {
                log.error("Erro ao validar token JWT: {}", e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.substring(7).trim();
    }
}
