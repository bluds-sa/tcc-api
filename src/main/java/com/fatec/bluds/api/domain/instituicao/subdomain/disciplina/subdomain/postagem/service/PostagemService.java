package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.dto.CreatePostagemDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.model.Postagem;

import java.util.List;

public interface PostagemService {
    public Postagem createPostagem(CreatePostagemDTO dto);
    public List<Postagem> listPostagensByDisciplina(Long disciplinaId);
}
