package com.fatec.bluds.api.domain.instituicao.controller;

import com.fatec.bluds.api.domain.instituicao.endereco.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateInstituicaoDTO(
        @NotBlank(message = "O nome não pode estar vazio.")
        String nome,

        @NotBlank(message = "O telefone não pode estar vazio.")
        String telefone,

        @NotBlank(message = "O CNPJ não pode estar vazio.")
        String cnpj,

        @NotBlank(message = "O email não pode estar vazio.")
        @Email(message = "O email deve ser válido.")
        String email,

        @NotNull(message = "O endereço não pode ser nulo.")
        Endereco endereco
) {
}
