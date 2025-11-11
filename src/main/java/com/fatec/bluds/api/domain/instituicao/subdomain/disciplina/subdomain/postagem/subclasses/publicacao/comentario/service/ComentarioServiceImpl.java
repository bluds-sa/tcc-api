package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.dto.CreateComentarioDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.dto.UpdateComentarioDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.model.Comentario;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.repository.ComentarioRepository;
import com.fatec.bluds.api.domain.usuario.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioRepository repository;

    public ComentarioServiceImpl(ComentarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Comentario responderPublicacao(Long publicacaoId, CreateComentarioDTO dto) {
        return null;
    }

    @Override
    public Comentario responderComentario(Long comentarioId, CreateComentarioDTO dto) {
        return null;
    }

    @Override
    public Comentario atualizarComentario(Long comentarioId, UpdateComentarioDTO dto) {
        return null;
    }

    @Override
    public void removerComentario(Usuario usuario, Long comentarioId) {

    }
}
