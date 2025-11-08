package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.dto.CreatePublicacaoDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.dto.UpdatePublicacaoDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.model.Publicacao;

import java.util.List;

public interface PublicacaoService {
    public Publicacao createPublicacao(CreatePublicacaoDTO dto);
    public Publicacao getPublicacaoById(Long id);
    public List<Publicacao> getPublicacoesByDisciplina(Long disciplinaId);
    public Publicacao updatePublicacao(UpdatePublicacaoDTO dto);
    public void removePublicacao(Long id);
}
