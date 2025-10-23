package com.fatec.bluds.api.domain.usuario.subclasses.Educador;

import com.fatec.bluds.api.domain.disciplina.Disciplina;
import com.fatec.bluds.api.domain.usuario.Usuario;
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
