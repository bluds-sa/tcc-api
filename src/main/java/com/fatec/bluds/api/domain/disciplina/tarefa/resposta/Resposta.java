package com.fatec.bluds.api.domain.disciplina.tarefa.resposta;

import com.fatec.bluds.api.domain.disciplina.tarefa.Tarefa;
import com.fatec.bluds.api.domain.Usuario.Subclasses.Estudante.Estudante;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "resposta")
@Table(name = "resposta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dataUpload;

    private Double nota;

    @NotNull
    private String caminhoAnexo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudante autor;

    @ManyToOne
    @JoinColumn(name = "tarefa_id", nullable = false)
    private Tarefa tarefa;
}
