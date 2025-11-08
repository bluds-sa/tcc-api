package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.repository;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.model.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
    
}
