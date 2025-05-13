package com.fatec.bluds.api.Usuario.Subclasses.Estudante;

import com.fatec.bluds.api.Usuario.Subclasses.Estudante.Enums.AnoEscolar;
import com.fatec.bluds.api.Usuario.Subclasses.Estudante.Enums.Periodo;
import com.fatec.bluds.api.Usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Estudante")
@Table(name = "Estudante")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Estudante extends Usuario {
    @Column(unique = true)
    @NotNull
    private String matricula;

    @Column
    @NotNull
    private Periodo periodo;

    @Column
    @NotNull
    private AnoEscolar anoEscolar;
}
