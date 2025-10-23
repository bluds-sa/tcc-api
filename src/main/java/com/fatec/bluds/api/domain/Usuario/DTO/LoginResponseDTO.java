package com.fatec.bluds.api.domain.Usuario.DTO;

public record LoginResponseDTO(
        String token,
        UsuarioDetailsDTO usuario) {
}
