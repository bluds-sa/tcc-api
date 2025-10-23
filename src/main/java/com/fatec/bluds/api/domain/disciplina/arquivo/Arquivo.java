package com.fatec.bluds.api.domain.disciplina.arquivo;

import com.fatec.bluds.api.domain.disciplina.model.Disciplina;
import com.fatec.bluds.api.domain.usuario.subclasses.Educador.Educador;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "arquivo")
@Table(name = "arquivo")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
