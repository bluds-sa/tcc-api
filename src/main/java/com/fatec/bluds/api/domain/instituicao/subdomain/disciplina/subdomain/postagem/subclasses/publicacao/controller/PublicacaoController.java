package com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.controller;

import com.fatec.bluds.api.domain.instituicao.subdomain.disciplina.subdomain.postagem.subclasses.publicacao.service.PublicacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publicacoes")
@Tag(name = "Módulo Disciplinas", description = "Responsável por operações relacionadas a Disciplinas dentro de uma Instiuição de Ensino")
public class PublicacaoController {

    @Autowired
    private final PublicacaoService publicacaoService;

    public PublicacaoController(PublicacaoService publicacaoService) {
        this.publicacaoService = publicacaoService;
    }


}
