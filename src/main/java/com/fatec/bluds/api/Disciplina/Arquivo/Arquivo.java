package com.fatec.bluds.api.Disciplina.Arquivo;

import com.fatec.bluds.api.Disciplina.Disciplina;
import com.fatec.bluds.api.Usuario.Subclasses.Educador.Educador;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity(name = "arquivo")
@Table(name = "arquivo")
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String caminho;

    @NotNull
    private LocalDateTime dataEnvio;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "educador_id")
    private Educador enviadoPor;
}
