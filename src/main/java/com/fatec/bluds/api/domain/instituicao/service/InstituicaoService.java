package com.fatec.bluds.api.domain.instituicao.service;

import com.fatec.bluds.api.domain.instituicao.dto.UpdateInstituicaoDTO;
import com.fatec.bluds.api.domain.instituicao.dto.CreateInstituicaoDTO;
import com.fatec.bluds.api.domain.instituicao.dto.InstituicaoDetailsDTO;
import com.fatec.bluds.api.domain.instituicao.model.InstituicaoEnsino;
import com.fatec.bluds.api.domain.instituicao.repository.InstituicaoRepository;
import com.fatec.bluds.api.domain.usuario.model.Usuario;
import com.fatec.bluds.api.domain.usuario.repository.UsuarioRepository;
import com.fatec.bluds.api.domain.usuario.subclasses.gestor.model.Gestor;
import com.fatec.bluds.api.infra.exceptions.instituicao.InstituicaoNotFoundException;
import com.fatec.bluds.api.infra.exceptions.usuario.UsuarioNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public InstituicaoEnsino createInstituicao(CreateInstituicaoDTO dto, Gestor gestor) {
        if (gestor.getInstituicaoEnsino() != null) {
            throw new IllegalStateException("O Gestor já está associado a uma Instituição de Ensino");
        }

        InstituicaoEnsino instituicaoEnsino = new InstituicaoEnsino();

        instituicaoEnsino.setNome(dto.nome());
        instituicaoEnsino.setTelefone(dto.telefone());
        instituicaoEnsino.setCnpj(dto.cnpj());
        instituicaoEnsino.setEmail(dto.email());
        instituicaoEnsino.setEndereco(dto.endereco());

        InstituicaoEnsino instituicaoEnsinoSaved = instituicaoRepository.save(instituicaoEnsino);

        bindUsuarioToInstituicao(gestor, instituicaoEnsino);

        return instituicaoEnsinoSaved;
    }

    public InstituicaoEnsino getInstituicaoById(Long id) {
        Optional<InstituicaoEnsino> optionalInstituicao = instituicaoRepository.findById(id);

        return optionalInstituicao.orElseThrow(
                () -> new InstituicaoNotFoundException("Não foi possível encontrar a Instituição de Ensino")
        );
    }

    public List<InstituicaoDetailsDTO> getInstituicoes() {
        return instituicaoRepository.findAllByOrderByNomeAsc().stream().map(InstituicaoDetailsDTO::new).toList();
    }

    @Transactional
    public InstituicaoEnsino updateInstituicao(Long id, UpdateInstituicaoDTO dto) {
        InstituicaoEnsino inst = getInstituicaoById(id);

        if (dto.nome() != null && !dto.nome().isBlank()) {
            inst.setNome(dto.nome());
        }

        if (dto.telefone() != null && !dto.telefone().isBlank()) {
            inst.setTelefone(dto.telefone());
        }

        if (dto.cnpj() != null && !dto.cnpj().isBlank()) {
            inst.setCnpj(dto.cnpj());
        }

        if (dto.email() != null && !dto.email().isBlank()) {
            inst.setEmail(dto.email());
        }

        if (dto.endereco() != null) {
            inst.setEndereco(dto.endereco());
        }

        instituicaoRepository.save(inst);

        return inst;
    }

    @Transactional
    public InstituicaoEnsino addUsuarioToInstituicao(Long instituicaoId, Long usuarioId) {
        InstituicaoEnsino instituicao = this.getInstituicaoById(instituicaoId);

        Usuario usuario = usuarioRepository
                .findById(usuarioId)
                .orElseThrow(UsuarioNotFoundException::new);

        if (usuario.getInstituicaoEnsino() != null) {
            throw new IllegalStateException("Usuário só pode estar associado a uma Instituição de Ensino");
        }

        bindUsuarioToInstituicao(usuario, instituicao);

        return instituicao;
    }

    @Transactional
    public InstituicaoEnsino removeUsuarioFromInstituicao(Long instituicaoId, Long usuarioId) {
        InstituicaoEnsino instituicao = this.getInstituicaoById(instituicaoId);

        Usuario usuario = usuarioRepository
                .findById(usuarioId)
                .orElseThrow(UsuarioNotFoundException::new);

        if (!instituicao.getUsuarios().contains(usuario)) {
            throw new IllegalStateException("Usuário não pertence a esta instituição.");
        }

        instituicao.getUsuarios().remove(usuario);

        unbindUsuarioFromInstituicao(usuario, instituicao);

        return instituicao;
    }

    private void bindUsuarioToInstituicao(Usuario usuario, InstituicaoEnsino instituicao) {
        usuario.setInstituicaoEnsino(instituicao);
        instituicao.getUsuarios().add(usuario);

        usuarioRepository.save(usuario);
        instituicaoRepository.save(instituicao);
    }

    private void unbindUsuarioFromInstituicao(Usuario usuario, InstituicaoEnsino instituicao) {
        usuario.setInstituicaoEnsino(null);
        instituicao.getUsuarios().remove(usuario);

        usuarioRepository.save(usuario);
        instituicaoRepository.save(instituicao);
    }
}
