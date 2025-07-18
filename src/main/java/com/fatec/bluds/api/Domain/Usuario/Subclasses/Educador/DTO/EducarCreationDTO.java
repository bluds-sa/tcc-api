package com.fatec.bluds.api.Domain.Usuario.Subclasses.Educador.DTO;

import com.fatec.bluds.api.Domain.Usuario.DTO.UserCreationDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record EducarCreationDTO(
        @Valid
        UserCreationDTO usuario,
        String matricula,
        @NotBlank
        String titulo
){
}
