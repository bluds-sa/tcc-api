package com.fatec.bluds.api.Domain.Usuario.Subclasses.Educador;

import com.fatec.bluds.api.Domain.Disciplina.Disciplina;
import com.fatec.bluds.api.Domain.Usuario.Usuario;
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
