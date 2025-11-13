package com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.service;

import com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.dto.CreatePerfilAcessibilidadeDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.dto.UpdatePerfilAcessibilidadeDTO;
import com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.model.PerfilAcessibilidade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilAcessibilidadeServiceImpl implements PerfilAcessibilidadeService {

    @Override
    public PerfilAcessibilidade createPerfilAcessibilidade(CreatePerfilAcessibilidadeDTO dto) {
        return null;
    }

    @Override
    public PerfilAcessibilidade getById(Long id) {
        return null;
    }

    @Override
    public PerfilAcessibilidade getByEstudante(Long estudanteId) {
        return null;
    }

    @Override
    public List<PerfilAcessibilidade> listarPefisDaInstituicao(Long instituicaoId) {
        return List.of();
    }

    @Override
    public PerfilAcessibilidade updatePerfilAcessibilidade(Long estudanteId, UpdatePerfilAcessibilidadeDTO dto) {
        return null;
    }

    @Override
    public void removePerfilAcessibilidade(Long id) {

    }
}
