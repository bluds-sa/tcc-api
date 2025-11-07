package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.model;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.model.Postagem;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "tarefa")
@DiscriminatorValue("TAREFA")
public class Publicacao extends Postagem {
}
