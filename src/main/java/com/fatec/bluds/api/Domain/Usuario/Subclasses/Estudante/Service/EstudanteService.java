package com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Service;

import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.DTO.EstudanteUpdateDTO;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Estudante;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Estudante.Repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository repository;

    public Estudante atualizar(Long id, EstudanteUpdateDTO dto) {
        Estudante estudante = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudante não encontrado"));

        estudante.setTelefone(dto.telefone());
        estudante.setGenero(dto.genero());
        estudante.setDataNascimento(dto.dataNascimento());

        return repository.save(estudante);
    }

    public EstudanteResponseDTO buscarPorId(Long id) {
        var estudante = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudante não encontrado"));
        return new EstudanteResponseDTO(
            estudante.getId(),
            estudante.getNome(),
            estudante.getCpf(),
            estudante.getEmail(),
            estudante.getMatricula(),
            estudante.getPeriodo(),
            estudante.getAnoEscolar(),
            estudante.getTelefone(),
            estudante.getGenero(),
            estudante.getDataNascimento()
        );
    }

}
