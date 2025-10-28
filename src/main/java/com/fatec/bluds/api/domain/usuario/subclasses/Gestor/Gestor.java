package com.fatec.bluds.api.domain.usuario.subclasses.Gestor;

import com.fatec.bluds.api.domain.usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Gestor")
@DiscriminatorValue("GESTOR")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gestor extends Usuario {
    @Column
    private String matricula;

    @Column
    private String cargo;
}
