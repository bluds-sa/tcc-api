package com.fatec.bluds.api.Disciplina.Postagem;

import com.fatec.bluds.api.Disciplina.Disciplina;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "postagem")
@Table(name = "postagem")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_postagem", discriminatorType = DiscriminatorType.STRING)
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titulo;

    @NotNull
    private String conteudo;

    @NotNull
    private LocalDateTime dataEnvio;

    private String caminhoAnexo;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;
}
