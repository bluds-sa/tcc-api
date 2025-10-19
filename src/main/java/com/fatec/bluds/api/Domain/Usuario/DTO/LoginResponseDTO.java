package com.fatec.bluds.api.Domain.Usuario.DTO;

public record LoginResponseDTO(
        String accessToken,
        String refreshToken,
        String tokenType
) {}
