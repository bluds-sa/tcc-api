package com.fatec.bluds.api.Disciplina.Tarefa;

import com.fatec.bluds.api.Disciplina.Postagem.Postagem;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity(name = "tarefa")
@DiscriminatorValue("TAREFA")
public class Tarefa extends Postagem {
    @NotNull
    private LocalDateTime dataExpiracao;

    @NotNull
    private Double valorTotal;
}
