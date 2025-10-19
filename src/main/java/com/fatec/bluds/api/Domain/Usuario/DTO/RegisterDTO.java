package com.fatec.bluds.api.Domain.Usuario.DTO;

import com.fatec.bluds.api.Domain.Usuario.DTO.Enums.UserTypeEnum;
import com.fatec.bluds.api.Domain.Usuario.Enums.Genero;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Enums.AnoEscolar;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Enums.Periodo;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * DTO de cadastro (Register).
 *
 * Regras importantes:
 * - email: válido e obrigatório
 * - senha: mínimo 8 caracteres, pelo menos 1 maiúscula, 1 minúscula, 1 número e 1 caractere especial
 * - userType: ESTUDANTE|EDUCADOR|GESTOR
 */
public record RegisterDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "CPF é obrigatório")
        String cpf,

        @NotBlank(message = "E-mail é obrigatório")
        @Email(message = "E-mail inválido")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
        // regex: pelo menos 1 minúscula, 1 maiúscula, 1 dígito e 1 caractere especial
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$",
                 message = "Senha deve conter minúscula, maiúscula, número e caractere especial")
        String senha,

        @NotNull(message = "Tipo de usuário é obrigatório")
        UserTypeEnum userType,

        @Nullable
        String telefone,

        @Nullable
        Genero genero,

        @Nullable
        LocalDate dataNascimento,

        /* Campos específicos para Estudante */
        @Nullable
        String matricula,

        @Nullable
        Periodo periodo,

        @Nullable
        AnoEscolar anoEscolar,

        /* Campos específicos para Educador / Gestor */
        @Nullable
        String titulo,

        @Nullable
        Boolean estudanteValido,

        @Nullable
        Boolean educadorValido
) {
    // Validações para matrícula
    @AssertTrue(message = "Estudante deve ter matrícula")
    public boolean isEstudanteValido() {
        if (userType == UserTypeEnum.ESTUDANTE) {
            return matricula != null && !matricula.isBlank();
        }
        return true;
    }

    @AssertTrue(message = "Educador deve ter título")
    public boolean isEducadorValido() {
        if (userType == UserTypeEnum.EDUCADOR) {
            return titulo != null && !titulo.isBlank();
        }
        return true;
    }
}
