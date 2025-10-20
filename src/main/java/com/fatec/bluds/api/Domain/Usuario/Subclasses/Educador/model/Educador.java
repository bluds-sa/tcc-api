package com.fatec.bluds.api.domain.usuario.subclasses.educador.model;

import com.fatec.bluds.api.domain.disciplina.Disciplina;
import com.fatec.bluds.api.domain.usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Educador")
@DiscriminatorValue("EDUCADOR")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Educador extends Usuario {

    @Column(nullable = true, unique = true)
    private String matricula;

    @Column(nullable = true)
    private String titulo;

    @OneToMany(mappedBy = "educador")
    private Set<Disciplina> disciplinas;

    @OneToMany(mappedBy = "educador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Formacao> formacoes = new HashSet<>();

    // Helpers para sincronizar os dois lados (formacao - educador)
    public void addFormacao(Formacao f) {
        f.setEducador(this);
        this.formacoes.add(f);
    }

    public void removeFormacao(Formacao f) {
        this.formacoes.remove(f);
        f.setEducador(null);
    }
}
