package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.arquivo.dto;

import java.time.LocalDateTime;

public record ArquivoDTO(
        Long id,
        String nome,
        String caminho,
        LocalDateTime dataEnvio,
        String enviadoPor
) {}
