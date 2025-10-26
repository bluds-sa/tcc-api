package com.fatec.bluds.api.domain.instituicao.repository;

import com.fatec.bluds.api.domain.instituicao.model.InstituicaoEnsino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituicaoRepository extends JpaRepository<InstituicaoEnsino, Long> {

}
