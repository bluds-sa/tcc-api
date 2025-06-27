package com.fatec.bluds.api.Usuario.Subclasses.Gestor;

import com.fatec.bluds.api.Instituicao.InstituicaoEnsino;
import com.fatec.bluds.api.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Gestor")
@Table(name = "Gestor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gestor extends Usuario {
    @Column
    private String matricula;

    @Column
    private String cargo;
}
