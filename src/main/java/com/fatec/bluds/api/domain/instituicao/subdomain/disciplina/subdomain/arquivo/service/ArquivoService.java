package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.arquivo.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.arquivo.model.Arquivo;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.arquivo.dto.ArquivoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArquivoService {
    Arquivo uploadArquivo(Long disciplinaId, Long educadorId, MultipartFile arquivo);
    List<ArquivoDTO> listarArquivos(Long disciplinaId);
}
