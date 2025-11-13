package com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.service;

import com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.dto.CreatePerfilAcessibilidadeDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.dto.UpdatePerfilAcessibilidadeDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.model.PerfilAcessibilidade;

import java.util.List;

public interface PerfilAcessibilidadeService {
    PerfilAcessibilidade createPerfilAcessibilidade(CreatePerfilAcessibilidadeDTO dto);
    PerfilAcessibilidade getById(Long id);
    PerfilAcessibilidade getByEstudante(Long estudanteId);
    List<PerfilAcessibilidade> listarPefisDaInstituicao(Long instituicaoId);
    PerfilAcessibilidade updatePerfilAcessibilidade(Long estudanteId, UpdatePerfilAcessibilidadeDTO dto);
    void removePerfilAcessibilidade(Long id);
}
