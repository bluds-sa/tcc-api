package com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gestor")
@Tag(name = "Módulo de Gestores", description = "Lida com operações relacionadas à classe Gestor")
public class GestorController {
}
