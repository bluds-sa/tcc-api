package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.repository;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
