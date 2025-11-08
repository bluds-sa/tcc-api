package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.dto.CreatePublicacaoDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.dto.UpdatePublicacaoDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.model.Publicacao;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacaoServiceImpl implements PublicacaoService {

    private final PublicacaoRepository publicacaoRepository;

    public PublicacaoServiceImpl(PublicacaoRepository publicacaoRepository) {
        this.publicacaoRepository = publicacaoRepository;
    }

    @Override
    public Publicacao createPublicacao(CreatePublicacaoDTO dto) {
        return null;
    }

    @Override
    public Publicacao getPublicacaoById(Long id) {
        return null;
    }

    @Override
    public List<Publicacao> getPublicacoesByDisciplina(Long disciplinaId) {
        return List.of();
    }

    @Override
    public Publicacao updatePublicacao(UpdatePublicacaoDTO dto) {
        return null;
    }

    @Override
    public void removePublicacao(Long id) {

    }
}
