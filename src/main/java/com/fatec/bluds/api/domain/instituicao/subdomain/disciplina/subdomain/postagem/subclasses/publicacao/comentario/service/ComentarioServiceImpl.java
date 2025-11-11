package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.dto.CreateComentarioDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.dto.UpdateComentarioDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.model.Comentario;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.comentario.repository.ComentarioRepository;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.service.PublicacaoService;
import com.fatec.bluds.api.domain.usuario.model.Usuario;
import com.fatec.bluds.api.domain.usuario.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioRepository repository;
    private final PublicacaoService publicacaoService;
    private final UsuarioService usuarioService;

    public ComentarioServiceImpl(ComentarioRepository repository, PublicacaoService publicacaoService, UsuarioService usuarioService) {
        this.repository = repository;
        this.publicacaoService = publicacaoService;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<Comentario> responderPublicacao(Long publicacaoId, CreateComentarioDTO dto) {
        return null;
    }

    @Override
    public List<Comentario> responderComentario(Long comentarioId, CreateComentarioDTO dto) {
        return null;
    }

    @Override
    public Comentario getComentarioById(Long comentarioId) {
        return null;
    }

    @Override
    public List<Comentario> listarComentariosDePublicacao(Long publicacaoId) {
        return List.of();
    }

    @Override
    public Comentario atualizarComentario(Long comentarioId, UpdateComentarioDTO dto) {
        return null;
    }

    @Override
    public void removerComentario(Long comentarioId) {

    }
}
