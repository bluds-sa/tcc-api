package com.fatec.bluds.api.domain.instituicao.service;

import com.fatec.bluds.api.domain.instituicao.dto.CreateInstituicaoDTO;
import com.fatec.bluds.api.domain.instituicao.model.InstituicaoEnsino;
import com.fatec.bluds.api.domain.instituicao.repository.InstituicaoRepository;
import com.fatec.bluds.api.domain.usuario.model.Usuario;
import com.fatec.bluds.api.domain.usuario.repository.UsuarioRepository;
import com.fatec.bluds.api.domain.usuario.subclasses.Gestor.Gestor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public InstituicaoEnsino createInstituicao(CreateInstituicaoDTO dto, Gestor gestor) {
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

    private void bindUsuarioToInstituicao(Usuario usuario, InstituicaoEnsino inst) {
        usuario.setInstituicaoEnsino(inst);

        usuarioRepository.save(usuario);
    }

}
