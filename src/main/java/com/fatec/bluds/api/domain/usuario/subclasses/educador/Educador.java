package com.fatec.bluds.api.domain.usuario.subclasses.educador;

import com.fatec.bluds.api.domain.disciplina.model.Disciplina;
import com.fatec.bluds.api.domain.usuario.model.Usuario;
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
