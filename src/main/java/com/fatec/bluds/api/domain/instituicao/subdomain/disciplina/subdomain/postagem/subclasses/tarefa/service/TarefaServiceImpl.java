package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.service;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.dto.CreateTarefaDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.dto.UpdateTarefaDTO;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.model.Tarefa;
import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public Tarefa createTarefa(CreateTarefaDTO dto) {
        return null;
    }

    @Override
    public Tarefa getTarefaById(Long id) {
        return null;
    }

    @Override
    public List<Tarefa> getTarefasByDisciplina(Long disciplinaId) {
        return List.of();
    }

    @Override
    public Tarefa updateTarefa(UpdateTarefaDTO dto) {
        return null;
    }

    @Override
    public void removeTarefa(Long id) {

    }
}
