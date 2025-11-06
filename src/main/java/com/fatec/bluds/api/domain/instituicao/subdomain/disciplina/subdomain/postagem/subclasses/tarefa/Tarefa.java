package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.Postagem;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.tarefa.resposta.Resposta;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "tarefa")
@DiscriminatorValue("TAREFA")
public class Tarefa extends Postagem {
    private LocalDateTime dataExpiracao;

    @NotNull
    private Double valorTotal;

    @OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Resposta> respostas = new HashSet<>();
}
