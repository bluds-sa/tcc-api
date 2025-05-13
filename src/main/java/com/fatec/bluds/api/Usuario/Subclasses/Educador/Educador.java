package com.fatec.bluds.api.Usuario.Subclasses.Educador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Educador")
@Table(name = "Educador")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Educador {
    @Column
    private String matricula;

    @Column
    private String titulo;
}
