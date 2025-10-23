package com.fatec.bluds.api.domain.disciplina;

import com.fatec.bluds.api.domain.disciplina.arquivo.Arquivo;
import com.fatec.bluds.api.domain.disciplina.postagem.Postagem;
import com.fatec.bluds.api.domain.Usuario.Subclasses.Educador.Educador;
import com.fatec.bluds.api.domain.Usuario.Subclasses.Estudante.Estudante;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Disciplina")
@Table(name = "Disciplina")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "educador_id", nullable = false)
    private Educador educador;

    @ManyToMany(mappedBy = "disciplinas")
    private Set<Estudante> estudantes = new HashSet<>();

    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Arquivo> arquivos = new HashSet<>();

    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Postagem> postagens = new HashSet<>();
}
