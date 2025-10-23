package com.fatec.bluds.api.domain.Usuario.Subclasses.Estudante.Enums;

public enum Periodo {
    MATUTINO("Matutino"),
    VESPERTINO("Vespertino"),
    NOTURNO("Noturno");

    private String periodoName;

    Periodo(String periodoName) {
        this.periodoName = periodoName;
    }
}
