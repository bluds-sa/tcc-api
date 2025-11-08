package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.tarefa.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefas")
@Tag(name = "Módulo Tarefas", description = "Responsável por operações relacionadas a Tarefas dentro de uma Disciplina")
public class TarefaController {
}
