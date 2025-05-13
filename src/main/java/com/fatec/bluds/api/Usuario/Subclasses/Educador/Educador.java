package com.fatec.bluds.api.Usuario.Subclasses.Educador;

import com.fatec.bluds.api.Instituicao.InstituicaoEnsino;
import com.fatec.bluds.api.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "Educador")
@Table(name = "Educador")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Educador extends Usuario {
    @Column
    private String matricula;

    @Column
    private String titulo;

    @ManyToMany
    @JoinTable(
            name = "educador_instituicao",
            joinColumns = @JoinColumn(name = "educador_id"), inverseJoinColumns = @JoinColumn(name = "instituicao_id")
    )
    private Set<InstituicaoEnsino> instituicoes;
}
