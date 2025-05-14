package com.fatec.bluds.api.Usuario.Subclasses.Gestor;

import com.fatec.bluds.api.Usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Gestor")
@Table(name = "Gestor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gestor extends Usuario {
    private String matricula;
    private String cargo;
}
