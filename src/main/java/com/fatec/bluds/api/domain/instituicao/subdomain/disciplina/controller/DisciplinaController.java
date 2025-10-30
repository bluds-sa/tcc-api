package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.controller;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.service.DisciplinaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplinas")
@Tag(name = "Módulo Disciplinas", description = "Responsável por operações relacionadas a Disciplinas dentro de uma Instiuição de Ensino")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;


}
