package com.fatec.bluds.api.Domain.Usuario.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "password_reset_tokens")
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String token;
    private LocalDateTime expiration;

    public PasswordResetToken() {}

    public PasswordResetToken(String email, String token, LocalDateTime expiration) {
        this.email = email;
        this.token = token;
        this.expiration = expiration;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiration);
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getToken() { return token; }
    public LocalDateTime getExpiration() { return expiration; }

    public void setEmail(String email) { this.email = email; }
    public void setToken(String token) { this.token = token; }
    public void setExpiration(LocalDateTime expiration) { this.expiration = expiration; }
}
