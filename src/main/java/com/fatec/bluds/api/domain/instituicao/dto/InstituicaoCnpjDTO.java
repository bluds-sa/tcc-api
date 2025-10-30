package com.fatec.bluds.api.domain.instituicao.dto;

import jakarta.validation.constraints.NotBlank;

public record InstituicaoCnpjDTO(
        @NotBlank
        String cnpj
) {
}
