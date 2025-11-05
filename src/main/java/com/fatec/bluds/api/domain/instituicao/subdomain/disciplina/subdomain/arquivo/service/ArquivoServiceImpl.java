package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.arquivo.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.arquivo.model.Arquivo;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.arquivo.dto.ArquivoDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.arquivo.repository.ArquivoRepository;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.model.Disciplina;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.repository.DisciplinaRepository;
import com.fatec.bluds.api.domain.usuario.subclasses.educador.model.Educador;
import com.fatec.bluds.api.domain.usuario.subclasses.educador.service.EducadorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArquivoServiceImpl implements ArquivoService {

    private final ArquivoRepository arquivoRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final EducadorService educadorService;

    private static final String UPLOAD_DIR = "uploads/disciplinas/";

    public ArquivoServiceImpl(ArquivoRepository arquivoRepository,
                              DisciplinaRepository disciplinaRepository,
                              EducadorService educadorService) {
        this.arquivoRepository = arquivoRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.educadorService = educadorService;
    }

    @Override
    public Arquivo uploadArquivo(Long disciplinaId, Long educadorId, MultipartFile arquivoMultipart) {
        Disciplina disciplina = disciplinaRepository.findById(disciplinaId)
                .orElseThrow(() -> new EntityNotFoundException("Disciplina com ID " + disciplinaId + " não encontrada"));

        Educador educador = educadorService.findById(educadorId);

        try {
            Path dirPath = Paths.get(UPLOAD_DIR + disciplinaId);
            Files.createDirectories(dirPath);

            Path filePath = dirPath.resolve(arquivoMultipart.getOriginalFilename());
            Files.copy(arquivoMultipart.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            Arquivo arquivo = new Arquivo();
            arquivo.setNome(arquivoMultipart.getOriginalFilename());
            arquivo.setCaminho(filePath.toString());
            arquivo.setDataEnvio(LocalDateTime.now());
            arquivo.setDisciplina(disciplina);
            arquivo.setEnviadoPor(educador);

            return arquivoRepository.save(arquivo);

        } catch (IOException e) {
            throw new RuntimeException("Falha ao armazenar o arquivo: " + e.getMessage(), e);
        }
    }

    @Override
    public List<ArquivoDTO> listarArquivos(Long disciplinaId) {
        List<Arquivo> arquivos = arquivoRepository.findAllByDisciplinaId(disciplinaId);
        return arquivos.stream()
                .map(a -> new ArquivoDTO(
                        a.getId(),
                        a.getNome(),
                        a.getCaminho(),
                        a.getDataEnvio(),
                        a.getEnviadoPor() != null ? a.getEnviadoPor().getNome() : null
                ))
                .toList();
    }
}
