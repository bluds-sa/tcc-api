package com.fatec.bluds.api.domain.usuario.subclasses.educador.service;

import com.fatec.bluds.api.domain.usuario.subclasses.educador.dto.*;
import com.fatec.bluds.api.domain.usuario.subclasses.educador.mapper.EducadorMapper;
import com.fatec.bluds.api.domain.usuario.subclasses.educador.model.*;
import com.fatec.bluds.api.domain.usuario.subclasses.educador.repository.*;
import com.fatec.bluds.api.infra.exceptions.Usuario.UsuarioNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EducadorService {

    @Autowired
    private EducadorRepository educadorRepository;

    @Autowired
    private FormacaoRepository formacaoRepository;

    @Autowired
    private EducadorMapper mapper;

    public Optional<EducadorResponseDTO> buscarPorId(Long id) {
        // Busca simples
        return educadorRepository.findWithFormacoesById(id).map(mapper::toDTO);
    }

    @Transactional
    public EducadorResponseDTO adicionarFormacao(Long educadorId, FormacaoRequestDTO dto) {
        Educador educador = educadorRepository.findWithFormacoesById(educadorId)
                .orElseThrow(() -> new UsuarioNotFoundException("Educador não encontrado."));

        if (dto.getTitulo() == null || dto.getInstituicao() == null) {
            throw new IllegalArgumentException("Título e instituição são obrigatórios.");
        }

        Formacao formacao = mapper.toEntity(dto);

        // sincroniza os dois lados (e cascade cuida do persist)
        educador.addFormacao(formacao);

        // No final da transação, a coleção está consistente
        return mapper.toDTO(educador);
    }

    public List<FormacaoResponseDTO> listarFormacoes(Long educadorId) {
        Educador educador = educadorRepository.findWithFormacoesById(educadorId)
                .orElseThrow(() -> new UsuarioNotFoundException("Educador não encontrado."));

        return mapper.toDTOList(new ArrayList<>(educador.getFormacoes()));
    }

    @Transactional
    public void removerFormacao(Long formacaoId) {
        Formacao f = formacaoRepository.findById(formacaoId)
                .orElseThrow(() -> new UsuarioNotFoundException("Formação não encontrada."));
        Educador e = f.getEducador();
        if (e != null) {
            e.removeFormacao(f); // sincroniza os dois lados
        }
        // Cascade + orphanRemoval já removem, aqui mais uma garantia
        formacaoRepository.delete(f);
    }
}
