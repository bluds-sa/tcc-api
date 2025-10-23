package com.fatec.bluds.api.domain.Usuario.Subclasses.Educador;

import com.fatec.bluds.api.domain.Disciplina.Disciplina;
import com.fatec.bluds.api.domain.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "Educador")
@DiscriminatorValue("EDUCADOR")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Educador extends Usuario {
    @Column
    private String matricula;

    @Column
    private String titulo;

    @OneToMany(mappedBy = "educador")
    private Set<Disciplina> disciplinas;
}
