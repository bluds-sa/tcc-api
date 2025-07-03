package com.fatec.bluds.api.Usuario.Subclasses.Educador;

import com.fatec.bluds.api.Disciplina.Disciplina;
import com.fatec.bluds.api.Instituicao.InstituicaoEnsino;
import com.fatec.bluds.api.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
