package com.fatec.bluds.api.infra.exceptions.dto;

import java.time.Instant;

public record ApiErrorDTO(
        int status,
        String error,
        String message,
        String path,
        Instant timestamp
){}